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

public class CallExprImpl extends ExpressionImpl implements CallExpr {

  public CallExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitCallExpr(this);
    else super.accept(visitor);
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
