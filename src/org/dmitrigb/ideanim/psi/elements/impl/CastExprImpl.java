package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.CastExpr;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class CastExprImpl extends BaseExpression implements CastExpr {

  public CastExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

  @Override
  @Nullable
  public TypeDesc getTypeDesc() {
    return findChildByClass(TypeDesc.class);
  }

}
