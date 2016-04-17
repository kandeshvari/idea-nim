package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.dmitrigb.ideanim.psi.elements.*;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;

public class DotExprImpl extends BaseExpression implements DotExpr {

  public DotExprImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public Expression getReceiver() {
    return (Expression) getFirstChild();
  }

  @Override
  @Nullable
  public Identifier getIdentifier() {
    PsiElement[] children = getChildren();
    return children.length == 2 ? (Identifier) children[1] : null;
  }

  @Override
  public Type getType() {
    Identifier identifier = getIdentifier();
    if (identifier != null) {
      PsiReference ref = identifier.getReference();
      if (ref != null) {
        PsiElement target = ref.resolve();
        if (target instanceof IdentifierDef) {
          PsiElement context = target.getContext();
          if (context instanceof ObjectFields) {
            TypeDesc typeDesc = ((ObjectFields) context).getDeclaredType();
            if (typeDesc != null)
              return typeDesc.toType();
          }
        }
      }
    }
    return Type.UNKNOWN;
  }
}
