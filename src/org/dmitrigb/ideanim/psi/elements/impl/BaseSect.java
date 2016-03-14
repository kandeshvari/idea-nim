package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;

public abstract class BaseSect<T extends PsiElement> extends BaseStatement {
  public BaseSect(ASTNode node) {
    super(node);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    for (T element : getDefinitionList()) {
      if (element == lastParent)
        return true;
      if (!element.processDeclarations(processor, state, null, place))
        return false;
    }
    return true;
  }

  public abstract List<T> getDefinitionList();
}
