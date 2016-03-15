package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiElement;

public interface TypeDesc extends PsiElement, SimpleTypeDesc {
  Expression getExpression();
}
