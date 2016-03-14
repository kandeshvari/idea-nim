package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.ConstDef;
import org.dmitrigb.ideanim.psi.elements.ConstSect;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class ConstSectImpl extends BaseSect<ConstDef> implements ConstSect {

  public ConstSectImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<ConstDef> getDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ConstDef.class);
  }

}
