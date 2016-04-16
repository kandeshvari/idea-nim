package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.Nullable;

public interface ContinueStmt extends Statement {
  @Nullable
  Expression getExpression();
}
