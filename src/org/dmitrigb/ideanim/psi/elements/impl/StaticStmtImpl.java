package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Block;
import org.dmitrigb.ideanim.psi.elements.StaticStmt;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class StaticStmtImpl extends BaseStatement implements StaticStmt {

  public StaticStmtImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Block getBlock() {
    return findChildByClass(Block.class);
  }

}
