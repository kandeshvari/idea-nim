package org.dmitrigb.ideanim.types;

import java.util.Set;

import org.dmitrigb.ideanim.psi.elements.EnumDef;
import org.dmitrigb.ideanim.psi.elements.TypeDef;

public class TEnum extends Type {

  private EnumDef enumDef;

  public TEnum(EnumDef enumDef) {
    this.enumDef = enumDef;
  }

  public EnumDef getEnum() {
    return enumDef;
  }

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return super.equals(other, s) || other instanceof TEnum && ((TEnum) other).enumDef == enumDef;
  }

  @Override
  public String toString() {
    return "enum";
  }
}
