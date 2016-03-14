package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import org.dmitrigb.ideanim.psi.IdentifierReference;
import org.dmitrigb.ideanim.psi.elements.CallExpr;
import org.dmitrigb.ideanim.psi.elements.Identifier;

public class IdentifierImpl extends BaseExpression implements Identifier {

  public IdentifierImpl(ASTNode node) {
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
