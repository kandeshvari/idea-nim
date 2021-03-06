package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.IdentPragmaPair;
import org.dmitrigb.ideanim.psi.elements.IdentifierDefs;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IdentifierDefsImpl extends ASTWrapperPsiElement implements IdentifierDefs {

  public IdentifierDefsImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<IdentPragmaPair> getIdentifiers() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentPragmaPair.class);
  }

  @Override
  @Nullable
  public TypeDesc getDeclaredType() {
    return findChildByClass(TypeDesc.class);
  }

  @Override
  @Nullable
  public Expression getInitializer() {
    return findChildByClass(Expression.class);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    return processor.execute(this, state);
  }
}
