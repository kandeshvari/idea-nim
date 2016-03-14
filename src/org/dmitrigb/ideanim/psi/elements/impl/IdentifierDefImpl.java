package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.psi.ElementFactory;
import org.dmitrigb.ideanim.psi.NimTypes;
import org.dmitrigb.ideanim.psi.elements.IdentifierDef;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class IdentifierDefImpl extends IdentifierImpl implements IdentifierDef {

  public IdentifierDefImpl(ASTNode node) {
    super(node);
  }

  @Override
  public String getName() {
    return getText();
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    ASTNode newNode = ElementFactory.createIdentNode(getProject(), name);
    getNode().replaceChild(getNode().findChildByType(NimTypes.IDENT), newNode);
    return this;
  }

  @Override
  public PsiReference getReference() {
    return null;
  }
}
