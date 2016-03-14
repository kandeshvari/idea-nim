package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface CaseStmt extends Statement {

  @NotNull
  List<Block> getBlockList();

  @NotNull
  List<Expression> getExpressionList();

}
