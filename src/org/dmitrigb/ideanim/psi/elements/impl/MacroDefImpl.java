package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.stubs.IStubElementType;
import org.dmitrigb.ideanim.psi.ProcResultPsiElement;
import org.dmitrigb.ideanim.psi.elements.MacroDef;
import org.dmitrigb.ideanim.psi.stubs.RoutineDefStub;
import org.jetbrains.annotations.NotNull;

public class MacroDefImpl extends BaseRoutineDef implements MacroDef {

  private PsiElement resultPseudoElement = new ProcResultPsiElement(this);

  public MacroDefImpl(ASTNode node) {
    super(node);
  }

  public MacroDefImpl(@NotNull RoutineDefStub stub, @NotNull IStubElementType nodeType) {
    super(stub, nodeType);
  }

  @Override
  protected boolean processResultDeclaration(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    if (lastParent != null)
      if (!resultPseudoElement.processDeclarations(processor, state, null, place))
        return false;
    return true;
  }
}
