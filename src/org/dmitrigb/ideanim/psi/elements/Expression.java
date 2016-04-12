package org.dmitrigb.ideanim.psi.elements;

import com.intellij.psi.PsiElement;
import org.dmitrigb.ideanim.types.Type;

public interface Expression extends PsiElement {

  enum TypeEvalMode {
    NO_DEREF,
    DEREF_ALL,
    DEREF_OBJECT_HIERARCHY
  }

  /**
   * Returns the type of the expression.
   */
  Type getType();

  /**
   * Returns the type that this expression evaluates to. For example the expression "int" will evaluate to the built-in
   * {@code int} type (unless there is another definition with the name {@code int}).
   */
  Type asType();

  Expression resolveType(TypeEvalMode mode);

  Expression evaluateType(TypeEvalMode mode);

}
