package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface CallExpr extends Expression {

  @NotNull
  List<DoBlock> getDoBlockList();

  @NotNull
  List<Expression> getArgumentList();

}
