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

public class DoBlockImpl extends ASTWrapperPsiElement implements DoBlock {

  public DoBlockImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitDoBlock(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ParamList getParamList() {
    return findChildByClass(ParamList.class);
  }

  @Override
  @Nullable
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Override
  @NotNull
  public List<Statement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Statement.class);
  }

  @Override
  @Nullable
  public TypeDesc getTypeDesc() {
    return findChildByClass(TypeDesc.class);
  }

}
