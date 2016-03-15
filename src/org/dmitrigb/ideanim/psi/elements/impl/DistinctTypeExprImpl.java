package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.DistinctTypeExpr;

public class DistinctTypeExprImpl extends BaseExpression implements DistinctTypeExpr {
  public DistinctTypeExprImpl(ASTNode node) {
    super(node);
  }
}
