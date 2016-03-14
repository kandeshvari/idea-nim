package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.YieldStmt;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class YieldStmtImpl extends BaseStatement implements YieldStmt {

  public YieldStmtImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

}
