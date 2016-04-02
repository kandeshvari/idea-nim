package org.dmitrigb.ideanim.psi;

import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.jetbrains.annotations.NotNull;

public class TypeReference extends IdentifierReference {
  public TypeReference(@NotNull Identifier element) {
    super(element);
  }

  @NotNull
  @Override
  protected SymbolResolver getSymbolResolver() {
    SymbolResolver resolver = new SymbolResolver(getElement());
    resolver.setTypesOnly(true);
    return resolver;
  }
}
