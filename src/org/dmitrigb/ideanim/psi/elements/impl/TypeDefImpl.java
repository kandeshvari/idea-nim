package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.psi.ElementFactory;
import org.dmitrigb.ideanim.psi.NimTypes;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.GenericParameters;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.Pragma;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
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
  @Nullable
  public GenericParameters getGenericParameters() {
    return findChildByClass(GenericParameters.class);
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
    idNode.replaceChild(idNode.findChildByType(NimTypes.IDENT), newNode);
    return this;
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return getIdentifier();
  }
}
