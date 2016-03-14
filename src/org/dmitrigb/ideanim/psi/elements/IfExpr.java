package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface IfExpr extends Expression {

  @NotNull
  List<Expression> getExpressionList();

}
