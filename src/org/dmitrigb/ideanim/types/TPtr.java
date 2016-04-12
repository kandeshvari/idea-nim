package org.dmitrigb.ideanim.types;

import java.util.Set;

public class TPtr extends Type {
  private Type baseType;

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return super.equals(other, s) || other instanceof TPtr && baseType.equals(((TPtr) other).baseType, s);
  }
}
