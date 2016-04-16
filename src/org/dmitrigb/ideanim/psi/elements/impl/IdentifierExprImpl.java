package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.dmitrigb.ideanim.psi.NimPsiTreeUtil;
import org.dmitrigb.ideanim.types.TGeneric;
import org.dmitrigb.ideanim.types.TPrimitive;
import org.dmitrigb.ideanim.types.Type;
import org.dmitrigb.ideanim.psi.elements.*;
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
      return null;
    PsiElement target = reference.resolve();
    TypeDesc typeDesc = NimPsiTreeUtil.getDeclaredType(target);
    if (typeDesc != null)
      return typeDesc.toType();
    return null;
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

    return TPrimitive.fromPredefinedTypeName(id.getText());
  }

}
