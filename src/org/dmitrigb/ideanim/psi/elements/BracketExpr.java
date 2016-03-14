package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface BracketExpr extends Expression {

  @NotNull
  List<Expression> getExpressionList();

}
