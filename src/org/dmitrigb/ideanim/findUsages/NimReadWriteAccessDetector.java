package org.dmitrigb.ideanim.findUsages;

import org.dmitrigb.ideanim.psi.AssignmentExpr;
import org.dmitrigb.ideanim.psi.IdentPragmaPair;
import org.dmitrigb.ideanim.psi.Identifier;
import org.dmitrigb.ideanim.psi.IdentifierExpr;
import org.dmitrigb.ideanim.psi.VarDef;
import com.intellij.codeInsight.highlighting.ReadWriteAccessDetector;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public class NimReadWriteAccessDetector extends ReadWriteAccessDetector {
  @Override
  public boolean isReadWriteAccessible(PsiElement element) {
    return element instanceof Identifier;
  }

  @Override
  public boolean isDeclarationWriteAccess(PsiElement element) {
    if (element instanceof Identifier) {
      element = element.getParent();
      if (element instanceof IdentPragmaPair) {
        element = element.getParent();
        if (element instanceof VarDef)
          if (((VarDef) element).getInitializer() != null)
            return true;
      }
    }
    return false;
  }

  @Override
  public Access getReferenceAccess(PsiElement referencedElement, PsiReference reference) {
    return getExpressionAccess(reference.getElement());
  }

  @Override
  public Access getExpressionAccess(PsiElement expression) {
    PsiElement element = expression;
    if (element instanceof Identifier) {
      element = element.getParent();
      if (element instanceof IdentifierExpr) {
        IdentifierExpr idExp = (IdentifierExpr) element;
        element = element.getParent();
        if (element instanceof AssignmentExpr) {
          if (element.getFirstChild() == idExp)
            return Access.Write;
        }
      }
    }
    return Access.Read;
  }
}
