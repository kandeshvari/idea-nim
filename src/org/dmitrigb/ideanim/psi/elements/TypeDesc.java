package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface TypeDesc extends PsiElement, SimpleTypeDesc {
  @NotNull
  Expression getExpression();
}
