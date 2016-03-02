package org.dmitrigb.ideanim.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveState;

public class IdentifierReference extends PsiReferenceBase<Identifier> {
  public IdentifierReference(@NotNull Identifier element) {
    super(element, TextRange.from(0, element.getTextLength()));
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    NimResolverProcessor rp = new NimResolverProcessor(getElement());
    ResolveState state = ResolveState.initial();
    PsiElement el = getElement();
    PsiElement parent;
    while ((parent = el.getParent()) != null) {
      if (!parent.processDeclarations(rp, state, el, getElement()))
        break;
      el = parent;
    }
    return rp.getResolvedTarget();
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }
}
