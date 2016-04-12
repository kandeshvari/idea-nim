package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.dmitrigb.ideanim.psi.elements.*;
import org.dmitrigb.ideanim.types.TObject;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

public class ObjectDefImpl extends BaseExpression implements ObjectDef {

  public ObjectDefImpl(ASTNode node) {
    super(node);
  }

  @Nullable
  @Override
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Nullable
  @Override
  public TypeDesc getSuperType() {
    return findChildByClass(TypeDesc.class);
  }

  @NotNull
  @Override
  public List<ObjectPart> getParts() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ObjectPart.class);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    for (ObjectPart part : getParts()) {
      if (!part.processDeclarations(processor, state, this, place))
        return false;
    }
    return true;
  }

  @Override
  public Type asType() {
    return new TObject(this);
  }
}
