package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.RefTypeExpr;

public class RefTypeExprImpl extends BaseExpression implements RefTypeExpr {
  public RefTypeExprImpl(ASTNode node) {
    super(node);
  }
}
