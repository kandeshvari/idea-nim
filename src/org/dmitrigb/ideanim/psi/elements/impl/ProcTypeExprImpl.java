package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.ProcTypeExpr;

public class ProcTypeExprImpl extends BaseExpression implements ProcTypeExpr {
  public ProcTypeExprImpl(ASTNode node) {
    super(node);
  }
}
