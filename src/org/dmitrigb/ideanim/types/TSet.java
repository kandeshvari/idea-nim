package org.dmitrigb.ideanim.types;

import java.util.Set;

public class TSet extends Type {
  private Type baseType;

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return super.equals(other, s) || other instanceof TSet && baseType.equals(((TSet) other).baseType, s);
  }
}
