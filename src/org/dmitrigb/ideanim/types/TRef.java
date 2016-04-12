package org.dmitrigb.ideanim.types;

import java.util.Set;

public class TRef extends Type {
  private Type baseType;

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return super.equals(other, s) || other instanceof TRef && baseType.equals(((TRef) other).baseType, s);
  }
}
