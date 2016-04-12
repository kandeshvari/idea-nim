package org.dmitrigb.ideanim.types;

import java.util.Set;

public class TOpenArray extends Type {
  private Type baseType;

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return super.equals(other, s) || other instanceof TOpenArray && baseType.equals(((TOpenArray) other).baseType, s);
  }
}
