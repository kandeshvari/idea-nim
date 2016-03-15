package org.dmitrigb.ideanim.psi;

import com.intellij.lang.ASTNode;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveState;
import com.intellij.psi.util.PsiTreeUtil;

public class IdentifierReference extends PsiReferenceBase<Identifier> {
  public IdentifierReference(@NotNull Identifier element) {
    super(element, TextRange.from(0, element.getTextLength()));
  }

  @NotNull
  protected SymbolResolver getSymbolResolver() {
    return new SymbolResolver(getElement());
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    SymbolResolver resolver = getSymbolResolver();
    PsiTreeUtil.treeWalkUp(resolver, getElement(), null, ResolveState.initial());
    return resolver.getResolvedTarget();
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }

  @Override
  public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
    if (resolve() instanceof ProcResultPsiElement)
      throw new IncorrectOperationException("Cannot rename the implicit variable 'result'.");

    ASTNode newNode = ElementFactory.createIdentNode(getElement().getProject(), newElementName);
    ASTNode elemNode = getElement().getNode();
    elemNode.replaceChild(elemNode.findChildByType(NimTypes.IDENT), newNode);
    return getElement();
  }
}
