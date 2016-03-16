package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class ObjectDefImpl extends BaseExpression implements ObjectDef {

  public ObjectDefImpl(ASTNode node) {
    super(node);
  }

  @Nullable
  @Override
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Nullable
  @Override
  public TypeDesc getSuperType() {
    return findChildByClass(TypeDesc.class);
  }

  @NotNull
  @Override
  public List<ObjectPart> getParts() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjectPart.class);
  }
}
