package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface DotExpr extends Expression {

  @NotNull
  Expression getExpression();

  @Nullable
  Identifier getIdentifier();

}
