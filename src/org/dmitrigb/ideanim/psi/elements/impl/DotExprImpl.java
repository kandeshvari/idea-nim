package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.DotExpr;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class DotExprImpl extends BaseExpression implements DotExpr {

  public DotExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public Expression getExpression() {
    return findNotNullChildByClass(Expression.class);
  }

  @Override
  @Nullable
  public Identifier getIdentifier() {
    return findChildByClass(Identifier.class);
  }

}
