package org.dmitrigb.ideanim.types;

import java.util.Set;

public class TArray extends Type {
  private Type baseType;
  private Type indexType;

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    if (super.equals(other, s))
      return true;
    if (!(other instanceof TArray))
      return false;
    TArray array = (TArray) other;
    return baseType.equals(array.baseType, s) && indexType.equals(array.indexType, s);
  }
}
