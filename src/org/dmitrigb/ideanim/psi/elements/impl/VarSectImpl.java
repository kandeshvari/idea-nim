package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.VarDef;
import org.dmitrigb.ideanim.psi.elements.VarSect;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class VarSectImpl extends BaseSect<VarDef> implements VarSect {

  public VarSectImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<VarDef> getDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VarDef.class);
  }

}
