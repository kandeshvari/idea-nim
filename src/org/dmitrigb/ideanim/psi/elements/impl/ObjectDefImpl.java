package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class ObjectDefImpl extends ASTWrapperPsiElement implements ObjectDef {

  public ObjectDefImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<Expression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Expression.class);
  }

  @Override
  @NotNull
  public List<IdentPragmaPair> getIdentPragmaPairList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentPragmaPair.class);
  }

  @Override
  @Nullable
  public Identifier getIdentifier() {
    return findChildByClass(Identifier.class);
  }

  @Override
  @NotNull
  public List<Pragma> getPragmaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Pragma.class);
  }

  @Override
  @NotNull
  public List<TypeDesc> getTypeDescList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TypeDesc.class);
  }

}
