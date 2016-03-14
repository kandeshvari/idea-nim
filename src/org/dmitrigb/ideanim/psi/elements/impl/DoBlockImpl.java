package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.Block;
import org.dmitrigb.ideanim.psi.elements.DoBlock;
import org.dmitrigb.ideanim.psi.elements.IdentifierDefs;
import org.dmitrigb.ideanim.psi.elements.Pragma;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class DoBlockImpl extends ASTWrapperPsiElement implements DoBlock {

  public DoBlockImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Block getBlock() {
    return findChildByClass(Block.class);
  }

  @Override
  @NotNull
  public List<IdentifierDefs> getIdentifierDefsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentifierDefs.class);
  }

  @Override
  @Nullable
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Override
  @Nullable
  public TypeDesc getTypeDesc() {
    return findChildByClass(TypeDesc.class);
  }

}
