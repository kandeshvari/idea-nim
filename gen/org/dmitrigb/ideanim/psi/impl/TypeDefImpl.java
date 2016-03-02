// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.dmitrigb.ideanim.psi.NimTypesBase.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.dmitrigb.ideanim.psi.*;

public class TypeDefImpl extends ASTWrapperPsiElement implements TypeDef {

  public TypeDefImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitTypeDef(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GenericParamList getGenericParamList() {
    return findChildByClass(GenericParamList.class);
  }

  @Override
  @Nullable
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Override
  @NotNull
  public Symbol getSymbol() {
    return findNotNullChildByClass(Symbol.class);
  }

}
