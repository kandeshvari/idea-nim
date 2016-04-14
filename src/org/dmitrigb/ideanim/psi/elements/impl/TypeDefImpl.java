package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.psi.ElementFactory;
import org.dmitrigb.ideanim.psi.ElementTypes;
import org.dmitrigb.ideanim.psi.elements.*;
import org.dmitrigb.ideanim.types.TEnum;
import org.dmitrigb.ideanim.types.TObject;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class TypeDefImpl extends ASTWrapperPsiElement implements TypeDef {

  public TypeDefImpl(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public Identifier getIdentifier() {
    return findNotNullChildByClass(Identifier.class);
  }

  @Override
  @NotNull
  public List<GenericParam> getGenericParameters() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GenericParam.class);
  }

  @Override
  @Nullable
  public Pragma getPragma() {
    return findChildByClass(Pragma.class);
  }

  @Override
  public Expression getDefinition() {
    return findChildByClass(Expression.class);
  }

  @Override
  public Type toType() {
    Expression def = getDefinition();
    if (def instanceof ObjectDef)
      return new TObject(this);
    if (def instanceof EnumDef)
      return new TEnum(this);
    return def.asType();
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    return processor.execute(this, state);
  }

  @Override
  public String getName() {
    return getIdentifier().getText();
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    ASTNode newNode = ElementFactory.createIdentNode(getProject(), name);
    ASTNode idNode = getIdentifier().getNode();
    idNode.replaceChild(idNode.findChildByType(ElementTypes.IDENT), newNode);
    return this;
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return getIdentifier();
  }
}
