package org.dmitrigb.ideanim.psi.mixins;

import org.dmitrigb.ideanim.psi.CallExpr;
import org.dmitrigb.ideanim.psi.Identifier;
import org.dmitrigb.ideanim.psi.IdentifierReference;
import org.dmitrigb.ideanim.psi.impl.ExpressionImpl;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;

public abstract class IdentifierMixin extends ExpressionImpl implements Identifier {
  public IdentifierMixin(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public PsiReference getReference() {
    if (getParent() instanceof PsiNamedElement)
      return null;

    if (getParent() instanceof CallExpr) {
      CallExpr callExpr = (CallExpr) getParent();
      callExpr.getArgumentList();
      //return new ProcReference();
    }

    return new IdentifierReference(this);
  }
}
