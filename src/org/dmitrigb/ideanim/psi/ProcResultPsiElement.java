package org.dmitrigb.ideanim.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.ResolveState;
import com.intellij.psi.impl.FakePsiElement;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.dmitrigb.ideanim.psi.elements.ProcExpr;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A pseudo PSI-element that represents the "declaration" of the implicit <i>result</i> variable.
 * Used as a target when resolving a reference to <i>result</i>.
 * Every {@link org.dmitrigb.ideanim.psi.elements.ProcDef proc}, {@link org.dmitrigb.ideanim.psi.elements.MacroDef macro}
 * etc has a unique instance of this class.
 */
public class ProcResultPsiElement extends FakePsiElement implements PsiNameIdentifierOwner {

  private PsiElement routine;

  public ProcResultPsiElement(PsiElement routine) {
    this.routine = routine;
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    return processor.execute(this, state);
  }

  @Override
  public PsiElement getParent() {
    return routine;
  }

  @NotNull
  @Override
  public PsiElement getNavigationElement() {
    return routine;
  }

  @Override
  public String getName() {
    return "result";
  }

  public TypeDesc getProcReturnType() {
    if (routine instanceof RoutineDef)
      return ((RoutineDef) routine).getReturnType();
    if (routine instanceof ProcExpr)
      return ((ProcExpr) routine).getReturnType();
    return null;
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return null;
  }
}
