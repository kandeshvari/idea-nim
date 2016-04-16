package org.dmitrigb.ideanim.types;

import org.dmitrigb.ideanim.psi.elements.Expression;

public class TStatic extends Type {
  private Expression underlyingType;

  public TStatic(Expression underlyingType) {
    this.underlyingType = underlyingType;
  }

  public Type getUnderlyingType() {
    return underlyingType.asType();
  }
}
