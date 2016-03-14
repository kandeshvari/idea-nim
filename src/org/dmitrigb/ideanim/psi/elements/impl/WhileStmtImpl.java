package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Block;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.WhileStmt;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class WhileStmtImpl extends BaseStatement implements WhileStmt {

  public WhileStmtImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Block getBlock() {
    return findChildByClass(Block.class);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

}
