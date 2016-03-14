package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.IdentPragmaPair;
import org.dmitrigb.ideanim.psi.elements.IdentifierDef;
import org.dmitrigb.ideanim.psi.elements.Pragma;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class IdentPragmaPairImpl extends ASTWrapperPsiElement implements IdentPragmaPair {

  public IdentPragmaPairImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Override
  @NotNull
  public IdentifierDef getIdentifier() {
    return findNotNullChildByClass(IdentifierDef.class);
  }

}
