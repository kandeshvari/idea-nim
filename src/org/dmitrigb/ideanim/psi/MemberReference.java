package org.dmitrigb.ideanim.psi;

import java.util.ArrayList;
import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.ObjectDef;
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
    MemberResolver memberResolver = new MemberResolver(getElement());
    if (!walkUpHierarchy(memberResolver, expression.getType()))
      return memberResolver.getResolvedTarget();

    // No matching field found, try to resolve to a proc
    if (!fieldsOnly) {
      List<Expression> args = new ArrayList<>();
      args.add(expression);
      if (callArgs != null)
        args.addAll(callArgs);
      RoutineResolver resolver = new RoutineResolver(getElement(), args);
      NimPsiTreeUtil.walkUp(resolver, getElement(), null, getElement().getText());
      return resolver.getResolvedTarget();
    }

    return null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    List<PsiElement> results = new ArrayList<>();

    MemberCollector memberCollector = new MemberCollector();
    Type type = expression.getType();
    walkUpHierarchy(memberCollector, type);
    results.addAll(memberCollector.getCandidates());

    if (!fieldsOnly) {
      RoutineCollector routineCollector = new RoutineCollector(expression);
      PsiElement def = Types.resolveDefinition(type);
      // TODO: take files of all objects in the hierarchy
      PsiFile file = def == null ? null : def.getContainingFile();
      NimPsiTreeUtil.walkUpWithFiles(routineCollector, getElement(), null, file == null ? new PsiFile[0] : new PsiFile[]{file});
      results.addAll(routineCollector.getCandidates());
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
