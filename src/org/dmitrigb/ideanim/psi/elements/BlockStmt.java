package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface BlockStmt extends Statement {

  @Nullable
  Block getBlock();

  @Nullable
  Identifier getIdentifier();

}
