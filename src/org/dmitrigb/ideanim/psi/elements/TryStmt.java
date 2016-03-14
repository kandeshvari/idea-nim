package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface TryStmt extends Statement {

  @NotNull
  List<Block> getBlockList();

  @NotNull
  List<Expression> getExpressionList();

}
