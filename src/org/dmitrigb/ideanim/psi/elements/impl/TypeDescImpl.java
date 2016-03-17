package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import com.intellij.lang.ASTNode;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.jetbrains.annotations.NotNull;

public class TypeDescImpl extends ASTWrapperPsiElement implements TypeDesc {

  public TypeDescImpl(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public Expression getExpression() {
    Expression child = findChildByClass(Expression.class);
    assert child != null;
    return child;
  }
}
