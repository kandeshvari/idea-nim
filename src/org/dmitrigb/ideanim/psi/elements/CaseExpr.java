package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface CaseExpr extends Expression {

  @NotNull
  List<Block> getBlockList();

  @NotNull
  List<Expression> getExpressionList();

}
