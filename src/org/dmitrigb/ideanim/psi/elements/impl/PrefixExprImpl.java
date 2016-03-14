package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class PrefixExprImpl extends BaseExpression implements PrefixExpr {

  public PrefixExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public EnumDef getEnumDef() {
    return findChildByClass(EnumDef.class);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

  @Override
  @NotNull
  public List<IdentifierDef> getIdentifierDefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentifierDef.class);
  }

  @Override
  @NotNull
  public List<IdentifierDefs> getIdentifierDefsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentifierDefs.class);
  }

  @Override
  @Nullable
  public ObjectDef getObjectDef() {
    return findChildByClass(ObjectDef.class);
  }

  @Override
  @Nullable
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Override
  @NotNull
  public List<TypeDesc> getTypeDescList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TypeDesc.class);
  }

}
