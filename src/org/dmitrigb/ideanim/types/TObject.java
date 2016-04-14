package org.dmitrigb.ideanim.types;

import org.dmitrigb.ideanim.psi.elements.ObjectDef;
import org.dmitrigb.ideanim.psi.elements.TypeDef;

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
}
