package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.Statement;

public class BaseStatement extends ASTWrapperPsiElement implements Statement {

  public BaseStatement(ASTNode node) {
    super(node);
  }

}
