package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.StaticTypeExpr;
import org.dmitrigb.ideanim.types.TStatic;
import org.dmitrigb.ideanim.types.Type;

public class StaticTypeExprImpl extends BaseExpression implements StaticTypeExpr {
  public StaticTypeExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Expression getUnderlyingType() {
    return PsiTreeUtil.getChildOfType(this, Expression.class);
  }

  @Override
  public Type asType() {
    return new TStatic(getUnderlyingType());
  }
}
