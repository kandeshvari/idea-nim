package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.LetSect;
import org.dmitrigb.ideanim.psi.elements.VarDef;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class LetSectImpl extends BaseSect<VarDef> implements LetSect {

  public LetSectImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<VarDef> getDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VarDef.class);
  }

}
