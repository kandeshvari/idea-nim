package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.InfixExpr;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class InfixExprImpl extends BaseExpression implements InfixExpr {

  public InfixExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

}
