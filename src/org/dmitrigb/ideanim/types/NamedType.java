package org.dmitrigb.ideanim.types;

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
  public String toString() {
    return definition.getIdentifier().getText() + " (" + getUnderlyingType().toString() + ")";
  }
}
