package org.dmitrigb.ideanim.psi;

import org.dmitrigb.ideanim.psi.impl.ExpressionImpl;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;

public abstract class IdentifierImplMixin extends ExpressionImpl implements Identifier {
  public IdentifierImplMixin(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public PsiReference getReference() {
    if (getParent() instanceof CallExpr) {
      CallExpr callExpr = (CallExpr) getParent();
      callExpr.getArgumentList();
      //return new ProcReference();
    }
    return new IdentifierReference(this);
  }
}
