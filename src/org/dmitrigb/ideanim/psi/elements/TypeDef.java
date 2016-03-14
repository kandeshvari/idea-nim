package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TypeDef extends PsiElement {

  @Nullable
  GenericParameters getGenericParameters();

  @NotNull
  Identifier getIdentifier();

  @Nullable
  Pragma getPragma();

}
