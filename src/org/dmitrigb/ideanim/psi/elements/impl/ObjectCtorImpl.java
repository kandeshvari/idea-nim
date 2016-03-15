package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.ObjectCtor;

public class ObjectCtorImpl extends BaseExpression implements ObjectCtor {
  public ObjectCtorImpl(ASTNode node) {
    super(node);
  }
}
