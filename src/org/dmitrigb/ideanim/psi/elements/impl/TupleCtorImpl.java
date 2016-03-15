package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.TupleCtor;

public class TupleCtorImpl extends BaseExpression implements TupleCtor {
  public TupleCtorImpl(ASTNode node) {
    super(node);
  }
}
