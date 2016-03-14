package org.dmitrigb.ideanim.psi.elements.impl;

import org.dmitrigb.ideanim.psi.elements.GenericParameters;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.Pragma;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class TypeDefImpl extends ASTWrapperPsiElement implements TypeDef {

  public TypeDefImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public GenericParameters getGenericParameters() {
    return findChildByClass(GenericParameters.class);
  }

  @Override
  @NotNull
  public Identifier getIdentifier() {
    return findNotNullChildByClass(Identifier.class);
  }

  @Override
  @Nullable
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

}
