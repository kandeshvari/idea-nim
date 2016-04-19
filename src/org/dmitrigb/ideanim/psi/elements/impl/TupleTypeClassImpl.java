package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.TupleTypeClass;

public class TupleTypeClassImpl extends BaseExpression implements TupleTypeClass {
  public TupleTypeClassImpl(ASTNode node) {
    super(node);
  }
}
