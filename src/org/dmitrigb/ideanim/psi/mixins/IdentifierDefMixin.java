package org.dmitrigb.ideanim.psi.mixins;

import org.dmitrigb.ideanim.psi.VarDef;
import org.dmitrigb.ideanim.psi.impl.IdentifierImpl;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;

public abstract class IdentifierDefMixin extends IdentifierImpl implements PsiNamedElement {
  public IdentifierDefMixin(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public String getName() {
    return getText();
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    throw new IncorrectOperationException("Not implemented.");
  }

  @Override
  public PsiReference getReference() {
    return null;
  }

  @NotNull
  @Override
  public PsiElement getNavigationElement() {
//    if (getParent() instanceof VarDef)
//      return getParent();
    return super.getNavigationElement();
  }
}
