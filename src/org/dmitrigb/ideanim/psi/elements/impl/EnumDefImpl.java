package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.EnumDef;
import org.dmitrigb.ideanim.psi.elements.EnumMember;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.types.TEnum;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class EnumDefImpl extends BaseExpression implements EnumDef {

  public EnumDefImpl(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public List<EnumMember> getMembers() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EnumMember.class);
  }

  @Override
  public Type asType() {
    return new TEnum(this);
  }
}
