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

public class VarDefImpl extends ASTWrapperPsiElement implements VarDef {

  public VarDefImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitVarDef(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

  @Override
  @NotNull
  public List<Pragma> getPragmaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Pragma.class);
  }

  @Override
  @NotNull
  public List<Symbol> getSymbolList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Symbol.class);
  }

  @Override
  @Nullable
  public TypeDesc getTypeDesc() {
    return findChildByClass(TypeDesc.class);
  }

}
