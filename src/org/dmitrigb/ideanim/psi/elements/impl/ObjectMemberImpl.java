package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.IdentPragmaPair;
import org.dmitrigb.ideanim.psi.elements.ObjectMember;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.jetbrains.annotations.NotNull;

public class ObjectMemberImpl extends ASTWrapperPsiElement implements ObjectMember {
  public ObjectMemberImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public List<IdentPragmaPair> getIdentifiers() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentPragmaPair.class);
  }

  @Override
  public TypeDesc getTypeDesc() {
    return findChildByClass(TypeDesc.class);
  }

  @Override
  public Expression getInitializer() {
    return findChildByClass(Expression.class);
  }
}
