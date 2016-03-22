package org.dmitrigb.ideanim.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MemberReference extends IdentifierReference {

  private Expression expression;

  public MemberReference(@NotNull Expression expression, @NotNull Identifier identifier) {
    super(identifier);
    this.expression = expression;
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    Expression type = expression.resolveType(Expression.TypeEvalMode.DEREF_ALL);
    if (type == null)
      return null;

    if (!(type instanceof ObjectDef))
      return null;

    ObjectDef objDef = (ObjectDef) type;

    MemberResolver resolver = new MemberResolver(getElement());
    ResolveState state = ResolveState.initial();

    while (objDef != null) {
      if (!objDef.processDeclarations(resolver, state, null, type))
        return resolver.getResolvedTarget();

      objDef = NimPsiTreeUtil.getSuperTypeDef(objDef);
    }

    return null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }
}
