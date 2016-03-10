// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.dmitrigb.ideanim.psi.NimTypesBase.*;
import org.dmitrigb.ideanim.psi.*;

public class PrefixExprImpl extends ExpressionImpl implements PrefixExpr {

  public PrefixExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitPrefixExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public Block getBlock() {
    return findChildByClass(Block.class);
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
