package org.dmitrigb.ideanim.types;

import java.util.Set;

import org.dmitrigb.ideanim.psi.elements.TypeDef;

public class NamedType extends Type {
  private TypeDef definition;

  public NamedType(TypeDef definition) {
    this.definition = definition;
  }

  public TypeDef getDefinition() {
    return definition;
  }

  public Type getUnderlyingType() {
    return definition.getDefinition().asType();
  }

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return super.equals(other, s) || other instanceof NamedType && getUnderlyingType().equals(((NamedType) other).getUnderlyingType(), s);
  }

  @Override
  public String toString() {
    return definition.getName();
  }
}
