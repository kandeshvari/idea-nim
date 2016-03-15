package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.VarTypeExpr;

public class VarTypeExprImpl extends BaseExpression implements VarTypeExpr {
  public VarTypeExprImpl(ASTNode node) {
    super(node);
  }
}
