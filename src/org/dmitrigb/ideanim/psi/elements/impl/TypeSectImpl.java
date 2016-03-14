package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.dmitrigb.ideanim.psi.elements.TypeSect;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class TypeSectImpl extends BaseStatement implements TypeSect {

  public TypeSectImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<TypeDef> getTypeDefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TypeDef.class);
  }

}
