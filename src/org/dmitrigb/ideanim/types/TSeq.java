package org.dmitrigb.ideanim.types;

import java.util.Set;

public class TSeq extends Type {
  private Type baseType;

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return super.equals(other, s) || other instanceof TSeq && baseType.equals(((TSeq) other).baseType, s);
  }
}
