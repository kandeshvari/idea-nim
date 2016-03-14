package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface ProcExpr extends Expression {

  @Nullable
  Block getBlock();

  @Nullable
  Pragma getPragma();

  @Nullable
  TypeDesc getReturnType();

  @NotNull
  List<IdentifierDefs> getParameters();

}
