package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface InfixExpr extends Expression {

  @Nullable
  Expression getExpression();

}
