package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface ConstSect extends Statement {

  @NotNull
  List<ConstDef> getDefinitionList();

}
