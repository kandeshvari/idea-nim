package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.NotNull;

public class IdentifierExprImpl extends BaseExpression implements IdentifierExpr {

  public IdentifierExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public Identifier getIdentifier() {
    return findNotNullChildByClass(Identifier.class);
  }

  @Override
  public Expression resolveType(TypeEvalMode mode) {
    PsiReference reference = getIdentifier().getReference();
    if (reference == null)
      return null;
    PsiElement target = reference.resolve();
    if (target == null)
      return null;

    if (target instanceof TypedElement) {
      TypeDesc typeDesc = ((TypedElement) target).getDeclaredType();
      if (typeDesc != null)
        return typeDesc.getExpression().evaluateType(mode);
    }

    return null;
  }

  @Override
  public Expression evaluateType(TypeEvalMode mode) {
    PsiReference reference = getIdentifier().getReference();
    if (reference == null)
      return null;

    PsiElement target = reference.resolve();

    if (target instanceof TypeDef)
      return ((TypeDef) target).getDefinition().evaluateType(mode);

    return null;
  }
}
