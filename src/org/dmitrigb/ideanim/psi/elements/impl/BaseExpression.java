package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;

public class BaseExpression extends ASTWrapperPsiElement implements Expression {

  public BaseExpression(ASTNode node) {
    super(node);
  }

  @Override
  public TypeDesc resolveType() {
    return null;
  }
}
