package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.RaiseStmt;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class RaiseStmtImpl extends BaseStatement implements RaiseStmt {

  public RaiseStmtImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

}
