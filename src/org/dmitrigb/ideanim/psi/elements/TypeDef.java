package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TypeDef extends PsiNamedElement {

  @NotNull
  Identifier getIdentifier();

  @Nullable
  GenericParameters getGenericParameters();

  @Nullable
  Pragma getPragma();

  Expression getDefinition();
}
