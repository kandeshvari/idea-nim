package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.GenericParameters;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class GenericParametersImpl extends ASTWrapperPsiElement implements GenericParameters {

  public GenericParametersImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<Expression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Expression.class);
  }

  @Override
  @NotNull
  public List<Identifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Identifier.class);
  }

}
