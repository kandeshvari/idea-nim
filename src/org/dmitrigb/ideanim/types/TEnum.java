package org.dmitrigb.ideanim.types;

import org.dmitrigb.ideanim.psi.elements.EnumDef;
import org.dmitrigb.ideanim.psi.elements.TypeDef;

public class TEnum extends Type {

  private EnumDef enumDef;

  public TEnum(TypeDef definition) {
    super(definition);
    enumDef = (EnumDef) definition.getDefinition();
  }

  public TEnum(EnumDef enumDef) {
    this.enumDef = enumDef;
  }

  public EnumDef getEnum() {
    return enumDef;
  }
}
