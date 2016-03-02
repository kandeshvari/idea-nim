// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.dmitrigb.ideanim.psi.NimTypesBase.*;
import org.dmitrigb.ideanim.psi.RoutineDefMixin;
import org.dmitrigb.ideanim.psi.*;

public class RoutineDefImpl extends RoutineDefMixin implements RoutineDef {

  public RoutineDefImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitRoutineDef(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public Pattern getPattern() {
    return findChildByClass(Pattern.class);
  }

  @Override
  @Nullable
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Override
  @Nullable
  public Symbol getSymbol() {
    return findChildByClass(Symbol.class);
  }

  @Override
  @Nullable
  public GenericParamList getGenericParameters() {
    return findChildByClass(GenericParamList.class);
  }

  @Override
  @Nullable
  public ParamList getParameters() {
    return findChildByClass(ParamList.class);
  }

  @Override
  @Nullable
  public TypeDesc getReturnType() {
    return findChildByClass(TypeDesc.class);
  }

  @Override
  @Nullable
  public RoutineBody getBody() {
    return findChildByClass(RoutineBody.class);
  }

}
