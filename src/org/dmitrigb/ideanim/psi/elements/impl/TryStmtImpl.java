package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.Block;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.TryStmt;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class TryStmtImpl extends BaseStatement implements TryStmt {

  public TryStmtImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<Block> getBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Block.class);
  }

  @Override
  @NotNull
  public List<Expression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Expression.class);
  }

}
