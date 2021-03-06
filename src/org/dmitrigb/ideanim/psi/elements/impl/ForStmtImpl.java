package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.dmitrigb.ideanim.psi.elements.Block;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.ForStmt;
import org.dmitrigb.ideanim.psi.elements.IdentPragmaPair;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class ForStmtImpl extends BaseStatement implements ForStmt {

  public ForStmtImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Block getBlock() {
    return findChildByClass(Block.class);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

  @Override
  @NotNull
  public List<IdentPragmaPair> getIdentPragmaPairList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentPragmaPair.class);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    return lastParent == null || processor.execute(this, state);
  }
}
