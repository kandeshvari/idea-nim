package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.IdentifierExpr;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.dmitrigb.ideanim.psi.elements.TypedElement;
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
  public TypeDesc resolveType() {
    PsiReference reference = getIdentifier().getReference();
    if (reference == null)
      return null;
    PsiElement target = reference.resolve();
    if (target == null)
      return null;

    if (target instanceof TypedElement)
      return ((TypedElement) target).getDeclaredType();

    return null;
  }
}
