package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.RefTypeExpr;
import org.dmitrigb.ideanim.types.TRef;
import org.dmitrigb.ideanim.types.Type;

public class RefTypeExprImpl extends BaseExpression implements RefTypeExpr {
  public RefTypeExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Expression getBase() {
    return (Expression) getLastChild();
  }

  @Override
  public Type asType() {
    return new TRef(getBase());
  }

}
