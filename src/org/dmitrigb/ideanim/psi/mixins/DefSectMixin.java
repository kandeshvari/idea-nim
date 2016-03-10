package org.dmitrigb.ideanim.psi.mixins;

import java.util.List;

import org.dmitrigb.ideanim.psi.impl.StatementImpl;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;

public abstract class DefSectMixin<T extends PsiElement> extends StatementImpl {
  public DefSectMixin(ASTNode node) {
    super(node);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    for (T element : getDefinitionList()) {
      if (element == lastParent)
        return true;
      if (!element.processDeclarations(processor, state, null, place))
        return false;
    }
    return true;
  }

  public abstract List<T> getDefinitionList();
}
