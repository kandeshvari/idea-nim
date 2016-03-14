package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.Pragma;
import com.intellij.lang.ASTNode;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class PragmaImpl extends ASTWrapperPsiElement implements Pragma {

  public PragmaImpl(ASTNode node) {
    super(node);
  }

}
