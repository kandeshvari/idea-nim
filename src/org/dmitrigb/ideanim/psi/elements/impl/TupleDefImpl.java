package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.TupleDef;

public class TupleDefImpl extends BaseExpression implements TupleDef {
  public TupleDefImpl(ASTNode node) {
    super(node);
  }
}
