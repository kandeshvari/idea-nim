package org.dmitrigb.ideanim.types;

class TypePair {
  private Type t1;
  private Type t2;

  public TypePair(Type t1, Type t2) {
    this.t1 = t1;
    this.t2 = t2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TypePair)) return false;
    TypePair p = (TypePair) o;
    return t1 == p.t1 && t2 == p.t2;
  }

  @Override
  public int hashCode() {
    return 31 * System.identityHashCode(t1) + System.identityHashCode(t2);
  }
}
