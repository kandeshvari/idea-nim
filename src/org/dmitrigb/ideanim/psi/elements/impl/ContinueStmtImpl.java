package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.ContinueStmt;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.jetbrains.annotations.Nullable;

public class ContinueStmtImpl extends BaseStatement implements ContinueStmt {
  public ContinueStmtImpl(ASTNode node) {
    super(node);
  }

  @Nullable
  @Override
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }
}
