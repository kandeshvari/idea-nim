package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.psi.ElementFactory;
import org.dmitrigb.ideanim.psi.ElementTypes;
import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseRoutineDef extends BaseStatement implements RoutineDef {

  public BaseRoutineDef(ASTNode node) {
    super(node);
  }

  @Override
  @NotNull
  public List<GenericParam> getGenericParameters() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GenericParam.class);
  }

  @Override
  @Nullable
  public Identifier getIdentifier() {
    return findChildByClass(Identifier.class);
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return getIdentifier();
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
  @NotNull
  public List<IdentifierDefs> getParameters() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IdentifierDefs.class);
  }

  @Override
  @Nullable
  public TypeDesc getReturnType() {
    return findChildByClass(TypeDesc.class);
  }

  @Override
  @Nullable
  public Block getBody() {
    return findChildByClass(Block.class);
  }

  @Override
  public boolean isForwardDeclaration() {
    return getBody() == null;
  }

  @Override
  public int getParameterCount() {
    return (int) getParameters().stream().flatMap(def -> def.getIdentifiers().stream()).count();
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    if (lastParent != null) {
      List<IdentifierDefs> params = getParameters();
      for (IdentifierDefs param : params) {
        if (!param.processDeclarations(processor, state, null, place))
          return false;
      }
      List<GenericParam> genericParams = getGenericParameters();
      for (GenericParam param : genericParams) {
        if (!param.processDeclarations(processor, state, null, place))
          return false;
      }
      if (!processResultDeclaration(processor, state, lastParent, place))
        return false;
    }
    return processor.execute(this, state);
  }

  protected boolean processResultDeclaration(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    return true;
  }

  @Override
  public int getTextOffset() {
    Identifier id = getIdentifier();
    return id != null ? id.getTextOffset() : super.getTextOffset();
  }

  @Override
  public String getName() {
    Identifier id = getIdentifier();
    return id == null ? null : id.getText();
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    ASTNode newNode = ElementFactory.createIdentNode(getProject(), name);
    ASTNode node = getIdentifier().getNode();
    node.replaceChild(node.findChildByType(ElementTypes.IDENT), newNode);
    return this;
  }
}
