package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.ExprStmt;
import org.dmitrigb.ideanim.psi.elements.Expression;

public class ExprStmtImpl extends BaseStatement implements ExprStmt {

  public ExprStmtImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }
}
