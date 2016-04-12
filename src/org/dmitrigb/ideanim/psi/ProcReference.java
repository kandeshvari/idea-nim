package org.dmitrigb.ideanim.psi;

import java.util.List;

import com.intellij.psi.PsiElement;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProcReference extends IdentifierReference {

  private List<Expression> arguments;

  public ProcReference(@NotNull Identifier procId, List<Expression> arguments) {
    super(procId);
    this.arguments = arguments;
  }

  @NotNull
  @Override
  protected SymbolResolver getSymbolResolver() {
    return new RoutineResolver(getElement(), arguments);
  }

  @Override
  public boolean isReferenceTo(PsiElement element) {
    PsiElement target = super.resolve();
    if (target == element)
      return true;
    if (target instanceof RoutineDef) {
      RoutineDef routine = (RoutineDef) target;
      if (routine.isForwardDeclaration()) {
        RoutineDef fullDef = NimPsiTreeUtil.getFullDefinition(routine);
        if (fullDef == element)
          return true;
      }
    }
    return false;
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    PsiElement target = super.resolve();
    if (target instanceof RoutineDef) {
      RoutineDef routine = (RoutineDef) target;
      if (routine.isForwardDeclaration()) {
        PsiElement target2 = NimPsiTreeUtil.getFullDefinition(routine);
        if (target2 != null)
          return target2;
      }
    }
    return target;
  }

}
