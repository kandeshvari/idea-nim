package org.dmitrigb.ideanim.types;

import org.dmitrigb.ideanim.psi.elements.IdentifierDef;

public class TGeneric extends Type {
  private IdentifierDef symbol;

  public TGeneric(IdentifierDef symbol) {
    this.symbol = symbol;
  }
}
