package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface BreakStmt extends Statement {

  @Nullable
  Expression getExpression();

}
