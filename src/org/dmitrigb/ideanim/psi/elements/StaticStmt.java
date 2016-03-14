package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface StaticStmt extends Statement {

  @Nullable
  Block getBlock();

}
