package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Block;
import org.dmitrigb.ideanim.psi.elements.BlockStmt;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class BlockStmtImpl extends BaseStatement implements BlockStmt {

  public BlockStmtImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Block getBlock() {
    return findChildByClass(Block.class);
  }

  @Override
  @Nullable
  public Identifier getIdentifier() {
    return findChildByClass(Identifier.class);
  }

}
