package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ConstDef extends PsiNamedElement, TypedElement {

  @Nullable
  Expression getExpression();

  @NotNull
  Identifier getIdentifier();

  @Nullable
  Pragma getPragma();

}
