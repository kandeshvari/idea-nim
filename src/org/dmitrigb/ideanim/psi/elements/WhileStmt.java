package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface WhileStmt extends Statement {

  @Nullable
  Block getBlock();

  @Nullable
  Expression getExpression();

}
