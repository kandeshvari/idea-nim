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

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitPrefixExpr(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public EnumDef getEnumDef() {
    return findChildByClass(EnumDef.class);
  }

  @Override
  @NotNull
  public List<Expression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Expression.class);
  }

  @Override
  @Nullable
  public ObjectDef getObjectDef() {
    return findChildByClass(ObjectDef.class);
  }

  @Override
  @Nullable
  public ParamList getParamList() {
    return findChildByClass(ParamList.class);
  }

  @Override
  @Nullable
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Override
  @Nullable
  public PrefixExpr getPrefixExpr() {
    return findChildByClass(PrefixExpr.class);
  }

  @Override
  @NotNull
  public List<Statement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Statement.class);
  }

  @Override
  @NotNull
  public List<Symbol> getSymbolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Symbol.class);
  }

  @Override
  @NotNull
  public List<TypeDesc> getTypeDescList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TypeDesc.class);
  }

}
