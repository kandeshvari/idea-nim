package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface VarSect extends Statement {

  @NotNull
  List<VarDef> getDefinitionList();

}
