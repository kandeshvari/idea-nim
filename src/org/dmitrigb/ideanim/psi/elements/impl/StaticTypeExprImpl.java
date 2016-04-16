package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.StaticTypeExpr;
import org.dmitrigb.ideanim.types.TStatic;
import org.dmitrigb.ideanim.types.Type;

public class StaticTypeExprImpl extends BaseExpression implements StaticTypeExpr {
  public StaticTypeExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Expression getUnderlyingType() {
    return (Expression) getFirstChild();
  }

  @Override
  public Type asType() {
    return new TStatic(getUnderlyingType());
  }
}
