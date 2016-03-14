package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Literal;
import com.intellij.lang.ASTNode;

public class LiteralImpl extends BaseExpression implements Literal {

  public LiteralImpl(ASTNode node) {
    super(node);
  }

}
