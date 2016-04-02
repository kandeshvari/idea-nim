package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import org.dmitrigb.ideanim.psi.IdentifierReference;
import org.dmitrigb.ideanim.psi.MemberReference;
import org.dmitrigb.ideanim.psi.ProcReference;
import org.dmitrigb.ideanim.psi.TypeReference;
import org.dmitrigb.ideanim.psi.elements.*;

public class IdentifierImpl extends ASTWrapperPsiElement implements Identifier {

  public IdentifierImpl(ASTNode node) {
    super(node);
  }

  @Override
  public PsiReference getReference() {
    PsiElement parent = getParent();
    if (parent instanceof PsiNamedElement)
      return null;

    if (parent instanceof IdentifierExpr) {
      PsiElement grand = parent.getParent();

      if (grand instanceof SimpleTypeDesc || grand instanceof ObjectCtor)
        return new TypeReference(this);

      if (grand instanceof CallExpr)
        return new ProcReference(this, ((CallExpr) grand).getArgumentList());
    }

    if (parent instanceof DotExpr) {
      return new MemberReference(((DotExpr) parent).getExpression(), this);
    }

    if (parent instanceof CtorArg) {
      PsiElement ctor = parent.getParent();
      if (ctor instanceof ObjectCtor) {
        return new MemberReference((Expression) ctor, this);
      }
    }

    return new IdentifierReference(this);
  }
}
