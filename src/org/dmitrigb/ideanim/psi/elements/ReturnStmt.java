package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface ReturnStmt extends Statement {

  @Nullable
  Expression getExpression();

}
