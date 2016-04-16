package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

import org.jetbrains.annotations.NotNull;

public interface IncludeStmt extends Statement {
  @NotNull
  List<Expression> getFileNames();
}
