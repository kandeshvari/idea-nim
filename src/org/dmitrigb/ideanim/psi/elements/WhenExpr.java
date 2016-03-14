package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface WhenExpr extends Expression {

  @NotNull
  List<Expression> getExpressionList();

}
