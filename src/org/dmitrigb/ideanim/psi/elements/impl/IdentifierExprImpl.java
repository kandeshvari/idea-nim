package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.dmitrigb.ideanim.psi.elements.GenericParam;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.IdentifierDef;
import org.dmitrigb.ideanim.psi.elements.IdentifierExpr;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.dmitrigb.ideanim.types.TGeneric;
import org.dmitrigb.ideanim.types.Type;
import org.dmitrigb.ideanim.types.Types;
import org.jetbrains.annotations.NotNull;

public class IdentifierExprImpl extends BaseExpression implements IdentifierExpr {

  public IdentifierExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public Identifier getIdentifier() {
    return (Identifier) getFirstChild();
  }

  @Override
  public Type getType() {
    PsiReference reference = getIdentifier().getReference();
    if (reference == null)
      return Type.UNKNOWN;
    PsiElement target = reference.resolve();
    return Types.getDeclarationType(target);
  }

  @Override
  public Type asType() {
    Identifier id = getIdentifier();
    PsiReference reference = id.getReference();
    if (reference != null) {
      PsiElement target = reference.resolve();
      if (target instanceof TypeDef)
        return ((TypeDef) target).toType();
      if (target instanceof IdentifierDef) {
        PsiElement parent = target.getParent();
        if (parent instanceof GenericParam)
          return new TGeneric((IdentifierDef) target);
      }
      if (target != null) {
        System.err.println("asType: identifier resolved to non TypeDef: this=" + this + ", target=" + target);
        return Type.UNKNOWN;
      }
    }

    return Type.UNKNOWN;
  }

}
