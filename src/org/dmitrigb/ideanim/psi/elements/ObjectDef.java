package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ObjectDef extends Expression {

  @Nullable
  Pragma getPragma();

  @Nullable
  TypeDesc getSuperType();

  @NotNull
  List<ObjectPart> getParts();

}
