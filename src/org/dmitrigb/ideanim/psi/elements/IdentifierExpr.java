package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface IdentifierExpr extends Expression {

  @NotNull
  Identifier getIdentifier();

}
