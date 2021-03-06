package org.dmitrigb.ideanim.types;

import java.util.HashSet;
import java.util.Set;

import org.dmitrigb.ideanim.psi.elements.TypeDef;

public class Type {

  public static final Type UNKNOWN = new Type();

  @Override
  public boolean equals(Object o) {
    if (this == UNKNOWN || o == UNKNOWN)
      return false;
    return this == o || o instanceof Type && equals((Type) o, new HashSet<>());
  }

  protected boolean equals(Type other, Set<TypePair> s) {
    if (this == UNKNOWN || other == UNKNOWN)
      return false;
    if (this == other)
      return true;
    TypePair tp = new TypePair(this, other);
    if (s.contains(tp))
      return true;
    s.add(tp);
    return false;
  }

  @Override
  public String toString() {
    return "<unknown>";
  }
}
