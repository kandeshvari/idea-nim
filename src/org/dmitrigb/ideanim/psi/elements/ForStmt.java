package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface ForStmt extends Statement {

  @Nullable
  Block getBlock();

  @Nullable
  Expression getExpression();

  @NotNull
  List<IdentPragmaPair> getIdentPragmaPairList();

}
