package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.RefTypeExpr;

public class RefTypeExprImpl extends BaseExpression implements RefTypeExpr {
  public RefTypeExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }
}
