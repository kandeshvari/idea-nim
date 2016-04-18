package org.dmitrigb.ideanim.psi;

import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.IdentifierDefs;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.NotNull;

public class RoutineCollector extends SymbolCollector {

  private final Expression firstArg;

  public RoutineCollector(Expression firstArg) {
    super(null);
    this.firstArg = firstArg;
  }

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (element instanceof RoutineDef) {
      RoutineDef routine = (RoutineDef) element;
      List<IdentifierDefs> paramDefs = routine.getParameters();
      if (paramDefs.isEmpty())
        return true;
      TypeDesc typeDesc = paramDefs.get(0).getDeclaredType();
      Type paramType = typeDesc == null ? null : typeDesc.toType();
      if (paramType == null)
        return true;

      RoutineResolver.MatchCategory counts = RoutineResolver.matchArgument(firstArg, paramType);
      if (counts != null)
        super.execute(routine, state);
    }
    return true;
  }
}
