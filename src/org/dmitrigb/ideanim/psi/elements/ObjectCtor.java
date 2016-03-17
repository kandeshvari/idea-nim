package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

import org.jetbrains.annotations.NotNull;

public interface ObjectCtor extends Expression {
  @NotNull
  Expression getTypeExpression();

  @NotNull
  List<CtorArg> getArguments();
}
