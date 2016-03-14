package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.IfExpr;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class IfExprImpl extends BaseExpression implements IfExpr {

  public IfExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<Expression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Expression.class);
  }

}
