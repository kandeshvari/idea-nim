package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Block;
import org.dmitrigb.ideanim.psi.elements.Pragma;
import org.dmitrigb.ideanim.psi.elements.PragmaStmt;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class PragmaStmtImpl extends BaseStatement implements PragmaStmt {

  public PragmaStmtImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Block getBlock() {
    return findChildByClass(Block.class);
  }

  @Override
  @NotNull
  public Pragma getPragma() {
    return findNotNullChildByClass(Pragma.class);
  }

}
