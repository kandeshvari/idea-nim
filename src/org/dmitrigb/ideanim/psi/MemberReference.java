package org.dmitrigb.ideanim.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.dmitrigb.ideanim.psi.elements.DotExpr;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MemberReference extends PsiReferenceBase<DotExpr> {
  public MemberReference(@NotNull DotExpr element) {
    super(element, TextRange.create(0, element.getTextLength()));
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    DotExpr dotExpr = getElement();
    TypeDesc type = dotExpr.getExpression().resolveType();
    if (type == null)
      return null;
    System.out.println("Resolved type to: " + type.getText());
    return null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }
}
