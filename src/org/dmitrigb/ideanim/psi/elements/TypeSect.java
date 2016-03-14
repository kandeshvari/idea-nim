package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface TypeSect extends Statement {

  @NotNull
  List<TypeDef> getTypeDefList();

}
