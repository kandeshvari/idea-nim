package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.BracketExpr;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class BracketExprImpl extends BaseExpression implements BracketExpr {

  public BracketExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Expression getReceiver() {
    return (Expression) getFirstChild();
  }

  @Override
  @NotNull
  public List<Expression> getArguments() {
    List<Expression> list = PsiTreeUtil.getChildrenOfTypeAsList(this, Expression.class);
    return list.subList(1, list.size());
  }

}
