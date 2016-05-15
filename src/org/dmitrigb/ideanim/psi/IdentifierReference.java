package org.dmitrigb.ideanim.psi;

import java.util.stream.Collectors;

import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.psi.elements.GenericParam;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.dmitrigb.ideanim.psi.stubs.indices.RoutineIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IdentifierReference extends PsiReferenceBase<Identifier> {
  public IdentifierReference(@NotNull Identifier element) {
    super(element, TextRange.from(0, element.getTextLength()));
  }

  @NotNull
  protected SymbolResolver getSymbolResolver() {
    return SymbolResolver.forName(getElement().getText());
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    SymbolResolver resolver = getSymbolResolver();
    Identifier identifier = getElement();
    GlobalSearchScope scope = ImportProcessor.buildImportScope(identifier);
    NimPsiTreeUtil.walkUp(resolver, identifier, () -> {
      RoutineIndex index = RoutineIndex.INSTANCE;
      Project project = identifier.getProject();
      return index.get(identifier.getText(), project, scope);
    }, identifier.getText(), scope);
    return resolver.getResolvedTarget();
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    SymbolCollector collector = SymbolCollector.withFilter(el -> !(el instanceof TypeDef || el instanceof GenericParam));
    NimPsiTreeUtil.walkUp(collector, getElement(), () -> {
      RoutineIndex index = RoutineIndex.INSTANCE;
      Project project = getElement().getProject();
      GlobalSearchScope scope = ImportProcessor.buildImportScope(getElement());
      return index.getAllKeys(project).stream()
          .flatMap(key -> index.get(key, project, scope).stream())
          .collect(Collectors.toList());
    });
    return collector.getLookupElements().stream().map(le -> {
      if (le.getPsiElement() instanceof RoutineDef)
        return ((LookupElementBuilder) le).withInsertHandler(getRoutineInsertHandler(false));
      return le;
    }).toArray();
  }

  @NotNull
  public static InsertHandler<LookupElement> getRoutineInsertHandler(boolean ignoreFirstArg) {
    return (context, item) -> {
      Editor editor = context.getEditor();
      Document document = editor.getDocument();
      int offset = context.getTailOffset();
      document.insertString(offset, "()");
      RoutineDef def = (RoutineDef) item.getPsiElement();
      assert def != null;
      if (ignoreFirstArg)
        offset += def.getMaxParameterCount() == 1 ? 2 : 1;
      else
        offset += def.hasParams() ? 1 : 2;
      editor.getCaretModel().moveToOffset(offset);
    };
  }

  @Override
  public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
    if (resolve() instanceof ProcResultPsiElement)
      throw new IncorrectOperationException("Cannot rename the implicit variable 'result'.");

    ASTNode newNode = ElementFactory.createIdentNode(getElement().getProject(), newElementName);
    ASTNode elemNode = getElement().getNode();
    elemNode.replaceChild(elemNode.findChildByType(ElementTypes.IDENT), newNode);
    return getElement();
  }
}
