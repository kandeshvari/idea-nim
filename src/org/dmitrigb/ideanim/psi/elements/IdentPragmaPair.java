package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IdentPragmaPair extends PsiElement {

  @Nullable
  Pragma getPragma();

  @NotNull
  IdentifierDef getIdentifier();

}
