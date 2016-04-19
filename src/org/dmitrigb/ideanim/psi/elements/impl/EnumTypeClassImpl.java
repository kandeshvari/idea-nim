package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.EnumTypeClass;

public class EnumTypeClassImpl extends BaseExpression implements EnumTypeClass {
  public EnumTypeClassImpl(ASTNode node) {
    super(node);
  }
}
