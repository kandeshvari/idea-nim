package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.psi.stubs.IStubElementType;
import org.dmitrigb.ideanim.psi.elements.*;
import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.stubs.RoutineDefStub;
import org.jetbrains.annotations.NotNull;

public class IteratorDefImpl extends BaseRoutineDef implements IteratorDef {

  public IteratorDefImpl(ASTNode node) {
    super(node);
  }

  public IteratorDefImpl(@NotNull RoutineDefStub stub, @NotNull IStubElementType elementType) {
    super(stub, elementType);
  }

}
