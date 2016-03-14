package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.NilToken;
import com.intellij.lang.ASTNode;

public class NilTokenImpl extends BaseExpression implements NilToken {

  public NilTokenImpl(ASTNode node) {
    super(node);
  }

}
