// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.dmitrigb.ideanim.psi.NimTypesBase.*;
import org.dmitrigb.ideanim.psi.mixins.IdentifierDefsMixin;
import org.dmitrigb.ideanim.psi.*;

public class IdentifierDefsImpl extends IdentifierDefsMixin implements IdentifierDefs {

  public IdentifierDefsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitIdentifierDefs(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<IdentPragmaPair> getIdentPragmaPairList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentPragmaPair.class);
  }

  @Override
  @Nullable
  public TypeDesc getType() {
    return findChildByClass(TypeDesc.class);
  }

  @Override
  @Nullable
  public Expression getInitializer() {
    return findChildByClass(Expression.class);
  }

}
