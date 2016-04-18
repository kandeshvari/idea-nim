package org.dmitrigb.ideanim.psi.stubs;

import com.intellij.psi.stubs.StubElement;
import org.dmitrigb.ideanim.psi.elements.TypeDef;

public interface TypeDefStub extends StubElement<TypeDef> {
  String getName();
}
