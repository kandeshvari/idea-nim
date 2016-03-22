package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.Expression;

public class BaseExpression extends ASTWrapperPsiElement implements Expression {

  public BaseExpression(ASTNode node) {
    super(node);
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
