package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface PragmaStmt extends Statement {

  @Nullable
  Block getBlock();

  @NotNull
  Pragma getPragma();

}
