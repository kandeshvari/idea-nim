package org.dmitrigb.ideanim.psi;

import java.util.List;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.psi.util.PsiTreeUtil;
import org.dmitrigb.ideanim.psi.elements.*;
import org.dmitrigb.ideanim.types.TObject;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class NimPsiTreeUtil {

  @Nullable
  public static ObjectDef getSuperTypeDef(ObjectDef objectDef) {
    TypeDesc superTypeDesc = objectDef.getSuperType();
    if (superTypeDesc == null)
      return null;
    Type superType = superTypeDesc.toType();
    if (superType instanceof TObject)
      return ((TObject) superType).getObject();

    return null;
  }

  public static RoutineDef getForwardDeclaration(RoutineDef routine) {
    SymbolResolver resolver = new SymbolResolver(routine.getIdentifier());
    routine.getContext().processDeclarations(resolver, ResolveState.initial(), null, routine);
    PsiElement target = resolver.getResolvedTarget();
    if (target instanceof RoutineDef && ((RoutineDef) target).isForwardDeclaration())
      return (RoutineDef) target;
    return null;
  }

  public static RoutineDef getFullDefinition(RoutineDef routine) {
    SymbolResolver resolver = new SymbolResolver(routine.getIdentifier()) {
      @Override
      protected boolean accept(PsiElement element, ResolveState state) {
        return element instanceof RoutineDef && !((RoutineDef) element).isForwardDeclaration();
      }
    };
    routine.getContext().processDeclarations(resolver, ResolveState.initial(), null, routine);
    PsiElement target = resolver.getResolvedTarget();
    if (target instanceof RoutineDef)
      return (RoutineDef) target;
    return null;
  }

  public static boolean walkUp(@NotNull PsiScopeProcessor processor,
                               @NotNull PsiElement entrance,
                               @Nullable PsiElement maxScope,
                               String searchWord) {
    if (!PsiTreeUtil.treeWalkUp(processor, entrance, maxScope, ResolveState.initial()))
      return false;

    Project project = entrance.getContainingFile().getProject();
    PsiSearchHelper helper = PsiSearchHelper.SERVICE.getInstance(project);
    return helper.processAllFilesWithWord(searchWord, GlobalSearchScope.projectScope(project), file -> {
      if (!(file instanceof NimFile))
        return true;
      List<Statement> stmts = ((NimFile) file).getStatements();
      for (Statement stmt : stmts) {
        if (!stmt.processDeclarations(processor, ResolveState.initial(), null, entrance))
          return false;
      }
      return true;
    }, false);
  }

  public static boolean walkUpWithFiles(@NotNull PsiScopeProcessor processor,
                                        @NotNull PsiElement entrance,
                                        @Nullable PsiElement maxScope,
                                        PsiFile[] files) {
    if (!PsiTreeUtil.treeWalkUp(processor, entrance, maxScope, ResolveState.initial()))
      return false;

    for (PsiFile file : files) {
      if (!(file instanceof NimFile))
        continue;
      List<Statement> stmts = ((NimFile) file).getStatements();
      for (Statement stmt : stmts) {
        if (!stmt.processDeclarations(processor, ResolveState.initial(), null, entrance))
          return false;
      }
    }
    return true;
  }

  /**
   * If the given element has a declared type, then this method returns the corresponding {@link TypeDesc}.
   * Elements that can have a declared type include: object fields, routine parameters, variables and constants.
   */
  public static TypeDesc getDeclaredType(PsiElement element) {
    if (element instanceof Identifier)
      element = element.getParent();
    if (element instanceof IdentPragmaPair)
      element = element.getParent();

    if (element instanceof ProcResultPsiElement)
      return ((ProcResultPsiElement) element).getProcReturnType();
    if (element instanceof IdentifierDefs)
      return ((IdentifierDefs) element).getDeclaredType();
    if (element instanceof VarDef)
      return ((VarDef) element).getDeclaredType();
    if (element instanceof ConstDef)
      return ((ConstDef) element).getDeclaredType();
    if (element instanceof ObjectFields)
      return ((ObjectFields) element).getDeclaredType();

    return null;
  }
}
