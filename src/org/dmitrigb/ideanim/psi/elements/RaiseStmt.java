package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface RaiseStmt extends Statement {

  @Nullable
  Expression getExpression();

}
