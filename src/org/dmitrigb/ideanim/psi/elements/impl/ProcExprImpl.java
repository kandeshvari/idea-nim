package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.dmitrigb.ideanim.psi.ProcResultPsiElement;
import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class ProcExprImpl extends BaseExpression implements ProcExpr {

  private PsiElement resultPseudoElement = new ProcResultPsiElement(this);

  public ProcExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Block getBlock() {
    return findChildByClass(Block.class);
  }

  @Override
  @Nullable
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Override
  @Nullable
  public TypeDesc getReturnType() {
    return findChildByClass(TypeDesc.class);
  }

  @Override
  @NotNull
  public List<IdentifierDefs> getParameters() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentifierDefs.class);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    if (lastParent != null) {
      if (getReturnType() != null && !resultPseudoElement.processDeclarations(processor, state, null, place))
        return false;
      List<IdentifierDefs> params = getParameters();
      for (IdentifierDefs param : params) {
        if (!param.processDeclarations(processor, state, null, place))
          return false;
      }
    }
    return true;
  }
}
