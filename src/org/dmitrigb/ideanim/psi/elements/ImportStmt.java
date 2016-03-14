package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface ImportStmt extends Statement {

  @NotNull
  List<Expression> getExpressionList();

}
