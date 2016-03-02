package org.dmitrigb.ideanim.structureview;

import java.util.Collection;
import java.util.Collections;

import org.dmitrigb.ideanim.psi.ParamList;
import org.dmitrigb.ideanim.psi.ProcDef;
import org.dmitrigb.ideanim.psi.RoutineDef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;

public class RoutineTreeElement extends PsiTreeElementBase<RoutineDef> {

  public RoutineTreeElement(RoutineDef proc) {
    super(proc);
  }

  @NotNull
  @Override
  public Collection<StructureViewTreeElement> getChildrenBase() {
    return Collections.emptyList();
  }

  @Nullable
  @Override
  public String getPresentableText() {
    String sig = "()";
    ParamList params = getElement().getParameters();
    if (params != null)
      sig = params.getText();

    return getElement().getSymbol().getText() + sig;
  }
}
