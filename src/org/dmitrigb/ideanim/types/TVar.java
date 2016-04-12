package org.dmitrigb.ideanim.types;

import java.util.Set;

public class TVar extends Type {
  private Type baseType;

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return super.equals(other, s) || other instanceof TVar && baseType.equals(((TVar) other).baseType, s);
  }
}
