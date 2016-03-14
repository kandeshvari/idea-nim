package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import com.intellij.lang.ASTNode;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class TypeDescImpl extends ASTWrapperPsiElement implements TypeDesc {

  public TypeDescImpl(ASTNode node) {
    super(node);
  }

}
