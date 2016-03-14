package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.ReturnStmt;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class ReturnStmtImpl extends BaseStatement implements ReturnStmt {

  public ReturnStmtImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

}
