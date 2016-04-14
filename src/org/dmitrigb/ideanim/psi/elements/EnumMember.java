package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface EnumMember extends PsiNameIdentifierOwner {
  @NotNull
  Identifier getIdentifier();

  @Nullable
  Expression getExpression();
}
