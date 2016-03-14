package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface DiscardStmt extends Statement {

  @Nullable
  Expression getExpression();

}
