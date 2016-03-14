package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.AssignmentExpr;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class AssignmentExprImpl extends BaseExpression implements AssignmentExpr {

  public AssignmentExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

}
