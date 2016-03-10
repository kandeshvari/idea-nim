package org.dmitrigb.ideanim.psi.mixins;

import java.util.List;

import org.dmitrigb.ideanim.psi.IdentifierDefs;
import org.dmitrigb.ideanim.psi.RoutineDef;
import org.dmitrigb.ideanim.psi.impl.StatementImpl;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.util.IncorrectOperationException;

public abstract class RoutineDefMixin extends StatementImpl implements RoutineDef, PsiNamedElement {
  public RoutineDefMixin(ASTNode node) {
    super(node);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    if (lastParent != null) {
      List<IdentifierDefs> params = getParameterList();
      for (IdentifierDefs param : params) {
        param.processDeclarations(processor, state, null, place);
      }
    }
    return processor.execute(this, state);
  }

  @Override
  public int getTextOffset() {
    return getIdentifier().getTextOffset();
  }

  @Override
  public String getName() {
    return getIdentifier().getText();
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    throw new IncorrectOperationException("Not implemented");
  }
}
