package org.dmitrigb.ideanim.psi.stubs.impl;

import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import org.dmitrigb.ideanim.psi.ElementTypes;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.dmitrigb.ideanim.psi.stubs.TypeDefStub;

public class TypeDefStubImpl extends StubBase<TypeDef> implements TypeDefStub {

  private String name;

  public TypeDefStubImpl(StubElement parent, String name) {
    super(parent, ElementTypes.TYPE_DEF);
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
