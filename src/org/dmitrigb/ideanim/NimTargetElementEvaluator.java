package org.dmitrigb.ideanim;

import com.intellij.codeInsight.TargetElementEvaluator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NimTargetElementEvaluator implements TargetElementEvaluator {
  @Override
  public boolean includeSelfInGotoImplementation(@NotNull PsiElement element) {
    if (element instanceof RoutineDef && ((RoutineDef) element).isForwardDeclaration())
      return false;
    return true;
  }

  @Nullable
  @Override
  public PsiElement getElementByReference(@NotNull PsiReference ref, int flags) {
    return null;
  }
}
