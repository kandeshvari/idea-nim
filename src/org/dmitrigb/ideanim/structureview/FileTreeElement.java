package org.dmitrigb.ideanim.structureview;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.dmitrigb.ideanim.psi.NimFile;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;

public class FileTreeElement extends PsiTreeElementBase<NimFile> {

  public FileTreeElement(NimFile element) {
    super(element);
  }

  @NotNull
  @Override
  public Collection<StructureViewTreeElement> getChildrenBase() {
    RoutineDef[] routines = getElement().findChildrenByClass(RoutineDef.class);
    return Arrays.asList(routines).stream().map(RoutineTreeElement::new).collect(Collectors.toList());
  }

  @Nullable
  @Override
  public String getPresentableText() {
    return getElement().getName();
  }
}
