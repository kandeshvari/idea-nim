package org.dmitrigb.ideanim.types;

import java.util.Set;

import org.dmitrigb.ideanim.psi.elements.Expression;

public class TRef extends Type {
  private Expression base;

  public TRef(Expression base) {
    this.base = base;
  }

  public Type getBaseType() {
    return base.asType();
  }

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return super.equals(other, s) || other instanceof TRef && getBaseType().equals(((TRef) other).getBaseType(), s);
  }
}
