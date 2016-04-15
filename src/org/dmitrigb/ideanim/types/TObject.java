package org.dmitrigb.ideanim.types;

import java.util.Set;

import org.dmitrigb.ideanim.psi.elements.ObjectDef;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;

public class TObject extends Type {

  private ObjectDef object;

  public TObject(ObjectDef object) {
    this.object = object;
  }

  public TObject(TypeDef definition) {
    super(definition);
    object = (ObjectDef) definition.getDefinition();
  }

  public ObjectDef getObject() {
    return object;
  }

  public Type getSuperType() {
    TypeDesc superTypeDesc = object.getSuperType();
    if (superTypeDesc != null)
      return superTypeDesc.toType();
    return null;
  }

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return super.equals(other, s) || other instanceof TObject && ((TObject) other).object == object;
  }

  @Override
  public String toString() {
    TypeDef def = getDefinition();
    return "object" + (def != null ? " (" + def.getName() + ")" : "");
  }
}
