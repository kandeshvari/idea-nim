package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.CallExpr;
import org.dmitrigb.ideanim.psi.elements.DoBlock;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class CallExprImpl extends BaseExpression implements CallExpr {

  public CallExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<DoBlock> getDoBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DoBlock.class);
  }

  @Override
  @NotNull
  public List<Expression> getArgumentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Expression.class);
  }

}
