package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TypeDef extends PsiNamedElement {

  @Nullable
  GenericParameters getGenericParameters();

  @NotNull
  Identifier getIdentifier();

  @Nullable
  Pragma getPragma();

}
