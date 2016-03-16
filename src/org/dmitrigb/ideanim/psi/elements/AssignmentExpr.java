package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;

public interface AssignmentExpr extends Expression {

  @NotNull
  Expression getLeftHandSide();

  @Nullable
  Expression getRightHandSide();

}
