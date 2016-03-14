package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface YieldStmt extends Statement {

  @Nullable
  Expression getExpression();

}
