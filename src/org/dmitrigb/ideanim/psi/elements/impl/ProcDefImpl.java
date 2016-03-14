package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.dmitrigb.ideanim.psi.ProcResultPsiElement;
import org.dmitrigb.ideanim.psi.elements.ProcDef;
import org.jetbrains.annotations.NotNull;

public class ProcDefImpl extends BaseRoutineDef implements ProcDef {

  private PsiElement resultPseudoElement = new ProcResultPsiElement(this);

  public ProcDefImpl(ASTNode node) {
    super(node);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    if (lastParent != null)
      if (!resultPseudoElement.processDeclarations(processor, state, null, place))
        return false;
    return super.processDeclarations(processor, state, lastParent, place);
  }
}
