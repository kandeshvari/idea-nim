package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.ObjectDef;
import org.dmitrigb.ideanim.psi.elements.PtrTypeExpr;

public class PtrTypeExprImpl extends BaseExpression implements PtrTypeExpr {
  public PtrTypeExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

  @Override
  public Expression evaluateType(TypeEvalMode mode) {
    switch (mode) {
      case DEREF_ALL:
        return getExpression().evaluateType(mode);
      case DEREF_OBJECT_HIERARCHY:
        if (getExpression() instanceof ObjectDef)
          return getExpression().evaluateType(mode);
        else
          return this;
      default:
        return this;
    }
  }
}
