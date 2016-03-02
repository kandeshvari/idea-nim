package org.dmitrigb.ideanim.structureview;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;

public class NimStructureViewBuilder extends TreeBasedStructureViewBuilder {
  private PsiFile psiFile;

  public NimStructureViewBuilder(PsiFile psiFile) {
    this.psiFile = psiFile;
  }

  @NotNull
  @Override
  public StructureViewModel createStructureViewModel(@Nullable Editor editor) {
    return new NimStructureViewModel(editor, psiFile);
  }
}
