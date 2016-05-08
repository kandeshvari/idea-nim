package org.dmitrigb.ideanim.psi.stubs.impl;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.psi.stubs.RoutineDefStub;
import org.jetbrains.annotations.NotNull;

public class RoutineDefStubImpl extends StubBase<RoutineDef> implements RoutineDefStub {

  private final String name;
  private final boolean hasParams;

  public RoutineDefStubImpl(StubElement parent, IStubElementType elementType, @NotNull String name, boolean hasParams) {
    super(parent, elementType);
    this.name = name;
    this.hasParams = hasParams;
  }

  @Override
  @NotNull
  public String getName() {
    return name;
  }

  @Override
  public boolean hasParams() {
    return hasParams;
  }
}
