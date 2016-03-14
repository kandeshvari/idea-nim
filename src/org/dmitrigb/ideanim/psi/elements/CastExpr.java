package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface CastExpr extends Expression {

  @Nullable
  Expression getExpression();

  @Nullable
  TypeDesc getTypeDesc();

}
