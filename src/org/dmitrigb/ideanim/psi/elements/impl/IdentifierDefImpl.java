package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.psi.ElementFactory;
import org.dmitrigb.ideanim.psi.ElementTypes;
import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    getNode().replaceChild(getNode().findChildByType(ElementTypes.IDENT), newNode);
    return this;
  }

  @Override
  public PsiReference getReference() {
    return null;
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return this;
  }
}
