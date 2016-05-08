package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IStubElementType;
import org.dmitrigb.ideanim.psi.elements.TemplateDef;
import org.dmitrigb.ideanim.psi.stubs.RoutineDefStub;
import org.jetbrains.annotations.NotNull;

public class TemplateDefImpl extends BaseRoutineDef implements TemplateDef {

  public TemplateDefImpl(ASTNode node) {
    super(node);
  }

  public TemplateDefImpl(@NotNull RoutineDefStub stub, @NotNull IStubElementType nodeType) {
    super(stub, nodeType);
  }

}
