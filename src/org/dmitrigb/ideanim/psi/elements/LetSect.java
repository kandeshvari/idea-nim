package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface LetSect extends Statement {

  @NotNull
  List<VarDef> getDefinitionList();

}
