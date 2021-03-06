package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;
import org.dmitrigb.ideanim.psi.elements.CtorArg;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.ObjectCtor;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.NotNull;

public class ObjectCtorImpl extends BaseExpression implements ObjectCtor {
  public ObjectCtorImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Type getType() {
    return getTypeExpression().asType();
  }

  @NotNull
  @Override
  public Expression getTypeExpression() {
    Expression child = findChildByClass(Expression.class);
    assert child != null;
    return child;
  }

  @NotNull
  @Override
  public List<CtorArg> getArguments() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CtorArg.class);
  }
}
