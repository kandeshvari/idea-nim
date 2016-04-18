package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.psi.ElementFactory;
import org.dmitrigb.ideanim.psi.ElementTypes;
import org.dmitrigb.ideanim.psi.elements.*;
import org.dmitrigb.ideanim.psi.stubs.TypeDefStub;
import org.dmitrigb.ideanim.types.NamedType;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeDefImpl extends StubBasedPsiElementBase<TypeDefStub> implements TypeDef {

  public TypeDefImpl(ASTNode node) {
    super(node);
  }

  public TypeDefImpl(@NotNull TypeDefStub stub, @NotNull IStubElementType nodeType) {
    super(stub, nodeType);
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
    return new NamedType(this);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    return processor.execute(this, state);
  }

  @Override
  public String getName() {
    TypeDefStub stub = getStub();
    if (stub != null)
      return stub.getName();
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

  @Override
  public PsiElement getContext() {
    PsiElement parent = getParent();
    assert parent instanceof TypeSect;
    return parent.getContext();
  }
}
