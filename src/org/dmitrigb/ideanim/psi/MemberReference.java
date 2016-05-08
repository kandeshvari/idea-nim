package org.dmitrigb.ideanim.psi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.ObjectFields;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.psi.stubs.indices.RoutineIndex;
import org.dmitrigb.ideanim.types.TObject;
import org.dmitrigb.ideanim.types.Type;
import org.dmitrigb.ideanim.types.Types;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MemberReference extends IdentifierReference {

  private Expression expression;
  private List<Expression> callArgs;
  private final boolean fieldsOnly;

  /**
   * A reference to a member of an object.
   * Using this constructor will create a reference that only resolves to fields, and not to procedures.
   * This is useful when resolving field references inside an object constructor.
   */
  public MemberReference(@NotNull Expression expression, @NotNull Identifier identifier) {
    super(identifier);
    this.expression = expression;
    fieldsOnly = true;
  }

  /**
   * A reference to a member of an object.
   * Using this constructor will create a reference that resolves to both - fields as well as procedures.
   */
  public MemberReference(@NotNull Expression expression, @NotNull Identifier identifier, @Nullable List<Expression> callArgs) {
    super(identifier);
    this.expression = expression;
    this.callArgs = callArgs;
    fieldsOnly = false;
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    String name = getElement().getText();
    SymbolResolver memberResolver = SymbolResolver.forName(name)
        .withFilter(elem -> elem instanceof ObjectFields);
    if (!walkUpHierarchy(memberResolver, expression.getType()))
      return memberResolver.getResolvedTarget();

    // No matching field found, try to resolve to a proc
    if (!fieldsOnly) {
      List<Expression> args = new ArrayList<>();
      args.add(expression);
      if (callArgs != null)
        args.addAll(callArgs);
      RoutineResolver resolver = new RoutineResolver(name, args);
      NimPsiTreeUtil.walkUpWithExtraElements(resolver, getElement(), () -> {
        Project project = getElement().getProject();
        RoutineIndex routineIndex = RoutineIndex.INSTANCE;
        GlobalSearchScope importScope = ImportProcessor.buildImportScope(getElement());
        return routineIndex.get(name, project, importScope);
      });
      return resolver.getResolvedTarget();
    }

    return null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    List<LookupElement> results = new ArrayList<>();

    SymbolCollector memberCollector = SymbolCollector.withFilter(el -> el instanceof ObjectFields);
    Type type = expression.getType();
    walkUpHierarchy(memberCollector, type);
    results.addAll(memberCollector.getLookupElements());

    if (!fieldsOnly) {
      RoutineCollector routineCollector = new RoutineCollector(expression);
      NimPsiTreeUtil.walkUpWithExtraElements(routineCollector, getElement(), () -> {
        Project project = getElement().getProject();
        GlobalSearchScope importScope = ImportProcessor.buildImportScope(getElement());
        RoutineIndex routineIndex = RoutineIndex.INSTANCE;
        return routineIndex.getAllKeys(project).stream()
            .flatMap(key -> routineIndex.get(key, project, importScope).stream().filter(RoutineDef::hasParams))
            .collect(Collectors.toList());
      });
      results.addAll(routineCollector.getLookupElements().stream()
          .map(le -> ((LookupElementBuilder) le).withInsertHandler(getRoutineInsertHandler(true)))
          .collect(Collectors.toList()));
    }

    return results.toArray();
  }

  private boolean walkUpHierarchy(PsiScopeProcessor processor, Type type) {
    ResolveState state = ResolveState.initial();
    type = Types.unwrapNamedAndDeref(type);
    while (type instanceof TObject) {
      TObject tObj = (TObject) type;
      if (!tObj.getObject().processDeclarations(processor, state, null, getElement()))
        return false;
      type = Types.unwrapNamedAndDeref(tObj.getSuperType());
    }
    return true;
  }
}
