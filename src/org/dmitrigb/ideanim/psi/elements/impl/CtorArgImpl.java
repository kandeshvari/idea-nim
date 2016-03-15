package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.CtorArg;
import org.jetbrains.annotations.NotNull;

public class CtorArgImpl extends ASTWrapperPsiElement implements CtorArg {
  public CtorArgImpl(@NotNull ASTNode node) {
    super(node);
  }
}
