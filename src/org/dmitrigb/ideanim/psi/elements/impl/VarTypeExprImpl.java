package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.VarTypeExpr;
import org.dmitrigb.ideanim.types.TVar;
import org.dmitrigb.ideanim.types.Type;

public class VarTypeExprImpl extends BaseExpression implements VarTypeExpr {
  public VarTypeExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Expression getExpression() {
    return (Expression) getLastChild();
  }

  @Override
  public Type asType() {
    return new TVar(getExpression());
  }
}
