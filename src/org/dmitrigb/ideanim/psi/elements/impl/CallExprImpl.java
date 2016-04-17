package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.dmitrigb.ideanim.psi.elements.*;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class CallExprImpl extends BaseExpression implements CallExpr {

  public CallExprImpl(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public Expression getCallee() {
    return (Expression) getFirstChild();
  }

  @Override
  @NotNull
  public List<DoBlock> getDoBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DoBlock.class);
  }

  @Override
  @NotNull
  public List<Expression> getArgumentList() {
    List<Expression> args = PsiTreeUtil.getChildrenOfTypeAsList(this, Expression.class);
    return args.subList(1, args.size());
  }

  @Override
  public Type getType() {
    Expression callee = getCallee();
    PsiReference ref = null;
    if (callee instanceof IdentifierExpr)
      ref = ((IdentifierExpr) callee).getIdentifier().getReference();
    else if (callee instanceof DotExpr) {
      Identifier identifier = ((DotExpr) callee).getIdentifier();
      if (identifier != null)
        ref = identifier.getReference();
    }

    if (ref != null) {
      PsiElement target = ref.resolve();
      if (target instanceof RoutineDef) {
        TypeDesc returnType = ((RoutineDef) target).getReturnType();
        if (returnType != null)
          return returnType.toType();
      }
    }

    return Type.UNKNOWN;
  }
}
