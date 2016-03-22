package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.dmitrigb.ideanim.psi.elements.TypeSect;
import org.jetbrains.annotations.NotNull;

public class TypeSectImpl extends BaseSect<TypeDef> implements TypeSect {

  public TypeSectImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<TypeDef> getDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TypeDef.class);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    for (TypeDef element : getDefinitionList()) {
      if (element == lastParent)
        continue;
      if (!element.processDeclarations(processor, state, null, place))
        return false;
    }
    return true;
  }
}
