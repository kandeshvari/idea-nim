package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.TupleTypeExpr;

public class TupleTypeExprImpl extends BaseExpression implements TupleTypeExpr {
  public TupleTypeExprImpl(ASTNode node) {
    super(node);
  }
}
