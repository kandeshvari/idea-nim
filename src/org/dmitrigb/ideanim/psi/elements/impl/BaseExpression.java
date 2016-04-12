package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.types.Type;
import org.dmitrigb.ideanim.psi.elements.Expression;

public abstract class BaseExpression extends ASTWrapperPsiElement implements Expression {

  public BaseExpression(ASTNode node) {
    super(node);
  }

  @Override
  public Type getType() {
    return Type.UNKNOWN;
  }

  @Override
  public Type asType() {
    return Type.UNKNOWN;
  }

  @Override
  public Expression resolveType(TypeEvalMode mode) {
    return null;
  }

  @Override
  public Expression evaluateType(TypeEvalMode mode) {
    return null;
  }
}
