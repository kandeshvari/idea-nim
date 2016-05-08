package org.dmitrigb.ideanim.psi.stubs;

import com.intellij.psi.stubs.NamedStub;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;

public interface RoutineDefStub extends NamedStub<RoutineDef> {
  boolean hasParams();
}
