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

public class ExprStmtImpl extends StatementImpl implements ExprStmt {

  public ExprStmtImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitExprStmt(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AssignmentExpr getAssignmentExpr() {
    return findChildByClass(AssignmentExpr.class);
  }

  @Override
  @Nullable
  public DoBlock getDoBlock() {
    return findChildByClass(DoBlock.class);
  }

  @Override
  @Nullable
  public Statement getStatement() {
    return findChildByClass(Statement.class);
  }

}
