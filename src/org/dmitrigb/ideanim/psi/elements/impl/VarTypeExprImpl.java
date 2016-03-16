package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.dmitrigb.ideanim.psi.elements.VarTypeExpr;

public class VarTypeExprImpl extends BaseExpression implements VarTypeExpr {
  public VarTypeExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

  @Override
  public TypeDef evaluateType() {
    return getExpression().evaluateType();
  }
}
