package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.IncludeStmt;
import org.jetbrains.annotations.NotNull;

public class IncludeStmtImpl extends BaseStatement implements IncludeStmt {
  public IncludeStmtImpl(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public List<Expression> getFileNames() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Expression.class);
  }
}
