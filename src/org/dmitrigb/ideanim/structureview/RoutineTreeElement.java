package org.dmitrigb.ideanim.structureview;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.dmitrigb.ideanim.psi.IdentifierDefs;
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
    StringBuilder sig = new StringBuilder("(");

    List<IdentifierDefs> params = getElement().getParameterList();
    for (IdentifierDefs param : params) {
      if (sig.length() > 1)
        sig.append(", ");
      sig.append(param.getText());
    }
    sig.append(")");

    return getElement().getIdentifier().getText() + sig;
  }
}
