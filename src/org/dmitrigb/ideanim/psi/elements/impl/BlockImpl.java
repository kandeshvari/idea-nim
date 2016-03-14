package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import org.dmitrigb.ideanim.psi.elements.Block;
import org.dmitrigb.ideanim.psi.elements.Statement;
import org.jetbrains.annotations.NotNull;

public class BlockImpl extends ASTWrapperPsiElement implements Block {

  public BlockImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<Statement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Statement.class);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    for (Statement statement : getStatementList()) {
      if (statement == lastParent)
        return true;
      if (!statement.processDeclarations(processor, state, null, place))
        return false;
    }
    return true;
  }
}
