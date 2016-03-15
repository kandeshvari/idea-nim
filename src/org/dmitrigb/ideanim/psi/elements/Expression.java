package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiElement;

public interface Expression extends PsiElement {

  TypeDesc resolveType();

}
