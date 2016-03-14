package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface GroupedExpr extends Expression {

  @Nullable
  Expression getExpression();

}
