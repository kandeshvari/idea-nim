package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ConstDef extends PsiElement, PsiNamedElement {

  @Nullable
  Expression getExpression();

  @NotNull
  Identifier getIdentifier();

  @Nullable
  Pragma getPragma();

  @Nullable
  TypeDesc getDeclaredType();

}
