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

  public Type getUnderlyingType() {
    Expression def = this.definition.getDefinition();
    return def == null ? Type.UNKNOWN : def.asType();
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
