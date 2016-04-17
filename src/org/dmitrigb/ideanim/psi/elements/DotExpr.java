package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface DotExpr extends Expression {

  @NotNull
  Expression getReceiver();

  @Nullable
  Identifier getIdentifier();

}
