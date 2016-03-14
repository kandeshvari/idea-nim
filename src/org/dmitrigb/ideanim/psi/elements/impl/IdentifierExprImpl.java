package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.IdentifierExpr;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class IdentifierExprImpl extends BaseExpression implements IdentifierExpr {

  public IdentifierExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public Identifier getIdentifier() {
    return findNotNullChildByClass(Identifier.class);
  }

}
