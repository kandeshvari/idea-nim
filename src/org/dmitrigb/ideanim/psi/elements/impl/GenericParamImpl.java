package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import org.dmitrigb.ideanim.psi.ElementTypes;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.GenericParam;
import org.dmitrigb.ideanim.psi.elements.IdentifierDef;
import org.jetbrains.annotations.NotNull;

public class GenericParamImpl extends ASTWrapperPsiElement implements GenericParam {

  public GenericParamImpl(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public List<IdentifierDef> getIdentifers() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentifierDef.class);
  }

  @Override
  public Expression getConstraints() {
    Expression expr = findChildByClass(Expression.class);
    if (expr == null)
      return null;
    if (expr.getNode().getTreePrev().getElementType() == ElementTypes.T_COLON)
      return expr;
    return null;
  }

  @Override
  public Expression getInitializer() {
    return null;
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    return processor.execute(this, state);
  }
}
