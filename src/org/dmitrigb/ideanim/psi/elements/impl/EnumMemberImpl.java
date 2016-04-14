package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.psi.elements.EnumMember;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EnumMemberImpl extends ASTWrapperPsiElement implements EnumMember {
  public EnumMemberImpl(@NotNull ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public Identifier getIdentifier() {
    return (Identifier) getFirstChild();
  }

  @Nullable
  @Override
  public Expression getExpression() {
    PsiElement[] children = getChildren();
    return children.length == 2 ? (Expression) children[1] : null;
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return getIdentifier();
  }

  @Override
  public String getName() {
    return getIdentifier().getText();
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    throw new IncorrectOperationException("not implementd");
  }
}
