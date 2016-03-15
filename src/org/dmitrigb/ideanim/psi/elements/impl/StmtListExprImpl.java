package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.StmtListExpr;

public class StmtListExprImpl extends BaseExpression implements StmtListExpr {
  public StmtListExprImpl(ASTNode node) {
    super(node);
  }
}
