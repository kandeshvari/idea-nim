package org.dmitrigb.ideanim.types;

import java.util.Set;

import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.TypeDef;

public class NamedType extends Type {
  private TypeDef definition;

  public NamedType(TypeDef definition) {
    this.definition = definition;
  }

  public TypeDef getDefinition() {
    return definition;
  }

  public String getName() {
    return definition.getName();
  }

  public Type getUnderlyingType() {
    Expression def = this.definition.getDefinition();
    return def == null ? null : def.asType();
  }

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    if (super.equals(other, s))
      return true;
    if (other instanceof NamedType) {
      NamedType otherType = (NamedType) other;
      if (definition == otherType.definition ||
          getUnderlyingType() != null && getUnderlyingType().equals(otherType.getUnderlyingType(), s))
        return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return definition.getName();
  }
}
