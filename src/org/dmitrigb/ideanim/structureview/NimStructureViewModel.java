package org.dmitrigb.ideanim.structureview;

import org.dmitrigb.ideanim.psi.NimFile;
import org.dmitrigb.ideanim.psi.ProcDef;
import org.jetbrains.annotations.NotNull;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.TextEditorBasedStructureViewModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;

public class NimStructureViewModel extends TextEditorBasedStructureViewModel {
  protected NimStructureViewModel(Editor editor, PsiFile psiFile) {
    super(editor, psiFile);
  }

  @NotNull
  @Override
  public StructureViewTreeElement getRoot() {
    return new FileTreeElement((NimFile) getPsiFile());
  }

  @NotNull
  @Override
  protected Class[] getSuitableClasses() {
    return new Class[] {ProcDef.class};
  }
}
