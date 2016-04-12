package org.dmitrigb.ideanim.types;

import java.util.Set;

import org.dmitrigb.ideanim.psi.elements.Literal;

public class TRange extends Type {
  private Type baseType;
  private Literal low;
  private Literal high;

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    if (super.equals(other, s))
      return true;
    if (!(other instanceof TRange))
      return false;
    TRange range = (TRange) other;
    return baseType.equals(range.baseType, s)
        && low.primitiveValue().equals(range.low.primitiveValue())
        && high.primitiveValue().equals(range.high.primitiveValue());
  }
}
