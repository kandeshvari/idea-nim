package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ObjectDef extends Expression {

  @Nullable
  Pragma getPragma();

  @Nullable
  TypeDesc getSuperType();

  @NotNull
  List<ObjectPart> getParts();

}
