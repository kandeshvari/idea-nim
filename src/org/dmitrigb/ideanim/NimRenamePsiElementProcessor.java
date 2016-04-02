package org.dmitrigb.ideanim;

import java.util.Map;

import com.intellij.psi.PsiElement;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import org.dmitrigb.ideanim.psi.NimPsiTreeUtil;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.jetbrains.annotations.NotNull;

public class NimRenamePsiElementProcessor extends RenamePsiElementProcessor {
  @Override
  public boolean canProcessElement(@NotNull PsiElement element) {
    return element instanceof RoutineDef;
  }

  @Override
  public void prepareRenaming(PsiElement element, String newName, Map<PsiElement, String> allRenames) {
    if (element instanceof RoutineDef) {
      RoutineDef routine = (RoutineDef) element;
      RoutineDef other;
      if (routine.isForwardDeclaration())
        other = NimPsiTreeUtil.getFullDefinition(routine);
      else
        other = NimPsiTreeUtil.getForwardDeclaration(routine);
      if (other != null)
        allRenames.put(other, newName);
    }
  }
}
