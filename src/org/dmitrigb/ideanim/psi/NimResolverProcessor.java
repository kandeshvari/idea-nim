package org.dmitrigb.ideanim.psi;

import org.jetbrains.annotations.NotNull;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.BaseScopeProcessor;

import static org.dmitrigb.ideanim.ResolveStateKeys.IN_UNREACHABLE_SCOPE;

public class NimResolverProcessor extends BaseScopeProcessor {

  private Identifier resolveId;

  private PsiElement target;

  public NimResolverProcessor(Identifier resolveId) {
    this.resolveId = resolveId;
  }

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (target == null && state.get(IN_UNREACHABLE_SCOPE))
      return false;

    if (element instanceof RoutineDef) {
      RoutineDef routine = (RoutineDef) element;
      Symbol name = routine.getSymbol();
      if (name != null && name.textMatches(resolveId)) {
        target = element;
        if (routine.getBody() != null)
          return false;
      }
    }
    return true;
  }

  public PsiElement getResolvedTarget() {
    return target;
  }
}
