package org.dmitrigb.ideanim.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.jetbrains.annotations.NotNull;

public class TypeReference extends IdentifierReference {
  public TypeReference(@NotNull Identifier element) {
    super(element);
  }

  @NotNull
  @Override
  protected SymbolResolver getSymbolResolver() {
    return new SymbolResolver(getElement()) {
      @Override
      protected boolean accept(PsiElement element, ResolveState state) {
        return element instanceof TypeDef;
      }
    };
  }
}
