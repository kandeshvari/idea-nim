package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.GroupedExpr;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class GroupedExprImpl extends BaseExpression implements GroupedExpr {

  public GroupedExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

}
