package org.dmitrigb.ideanim.types;

import java.util.HashSet;
import java.util.Set;

import org.dmitrigb.ideanim.psi.elements.TypeDef;

public class Type {

  public static final Type UNKNOWN = new Type();

  private final TypeDef definition;

  public Type() {
    definition = null;
  }

  public Type(TypeDef definition) {
    this.definition = definition;
  }

  public TypeDef getDefinition() {
    return definition;
  }

  @Override
  public boolean equals(Object o) {
    return this == o || o instanceof Type && equals((Type) o, new HashSet<>());
  }

  protected boolean equals(Type other, Set<TypePair> s) {
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
