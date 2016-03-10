package org.dmitrigb.ideanim.psi.mixins;

import org.dmitrigb.ideanim.psi.Block;
import org.dmitrigb.ideanim.psi.Statement;
import org.jetbrains.annotations.NotNull;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;

public abstract class BlockMixin extends ASTWrapperPsiElement implements Block {
  public BlockMixin(@NotNull ASTNode node) {
    super(node);
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
