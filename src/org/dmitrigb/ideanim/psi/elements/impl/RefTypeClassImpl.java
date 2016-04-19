package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.RefTypeClass;

public class RefTypeClassImpl extends BaseExpression implements RefTypeClass {
  public RefTypeClassImpl(ASTNode node) {
    super(node);
  }
}
