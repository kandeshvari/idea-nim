package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
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

}
