package org.dmitrigb.ideanim.psi;

import java.util.ArrayList;
import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.BaseScopeProcessor;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.IdentifierDefs;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.NotNull;

public class RoutineCollector extends BaseScopeProcessor {

  private final Expression firstArg;
  private List<RoutineDef> candidates = new ArrayList<>();

  public RoutineCollector(Expression firstArg) {
    this.firstArg = firstArg;
  }

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (element instanceof RoutineDef)
      match((RoutineDef) element);
    return true;
  }

  private void match(RoutineDef routine) {
    List<IdentifierDefs> paramDefs = routine.getParameters();
    if (paramDefs.isEmpty())
      return;
    TypeDesc typeDesc = paramDefs.get(0).getDeclaredType();
    Type paramType = typeDesc == null ? null : typeDesc.toType();
    if (paramType == null)
      return;

    RoutineResolver.MatchCategory counts = RoutineResolver.matchArgument(firstArg, paramType);
    if (counts != null)
      candidates.add(routine);
  }

  public List<RoutineDef> getCandidates() {
    return candidates;
  }
}
