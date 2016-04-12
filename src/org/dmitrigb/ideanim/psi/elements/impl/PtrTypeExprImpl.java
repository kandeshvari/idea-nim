package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.PtrTypeExpr;

public class PtrTypeExprImpl extends BaseExpression implements PtrTypeExpr {
  public PtrTypeExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

}
