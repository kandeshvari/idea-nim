package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiElement;

public interface Expression extends PsiElement {

  enum TypeEvalMode {
    NO_DEREF,
    DEREF_ALL,
    DEREF_OBJECT_HIERARCHY
  }


  Expression resolveType(TypeEvalMode mode);

  Expression evaluateType(TypeEvalMode mode);

}
