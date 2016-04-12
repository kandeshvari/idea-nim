package org.dmitrigb.ideanim.types;

import org.dmitrigb.ideanim.psi.elements.ObjectDef;

public class TObject extends Type {
  private ObjectDef definition;

  public TObject(ObjectDef definition) {
    this.definition = definition;
  }

  public ObjectDef getDefinition() {
    return definition;
  }
}
