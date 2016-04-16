package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ConstDef extends PsiNameIdentifierOwner {

  @Nullable
  Expression getExpression();

  @NotNull
  Identifier getIdentifier();

  @Nullable
  Pragma getPragma();

  @Nullable
  TypeDesc getDeclaredType();

}
