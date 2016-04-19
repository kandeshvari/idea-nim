package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.PtrTypeClass;

public class PtrTypeClassImpl extends BaseExpression implements PtrTypeClass {
  public PtrTypeClassImpl(ASTNode node) {
    super(node);
  }
}
