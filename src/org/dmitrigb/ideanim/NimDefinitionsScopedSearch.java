package org.dmitrigb.ideanim;

import com.intellij.openapi.application.QueryExecutorBase;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.search.searches.DefinitionsScopedSearch;
import com.intellij.util.Processor;
import org.dmitrigb.ideanim.psi.NimPsiTreeUtil;
import org.dmitrigb.ideanim.psi.SymbolResolver;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.jetbrains.annotations.NotNull;

/**
 * @see DefinitionsScopedSearch
 */
public class NimDefinitionsScopedSearch extends QueryExecutorBase<PsiElement, DefinitionsScopedSearch.SearchParameters> {
  @Override
  public void processQuery(@NotNull DefinitionsScopedSearch.SearchParameters queryParameters, @NotNull Processor<PsiElement> consumer) {
    PsiElement element = queryParameters.getElement();
    if (element instanceof RoutineDef) {
      RoutineDef routine = (RoutineDef) element;
      if (routine.isForwardDeclaration()) {
        PsiElement fullDef = NimPsiTreeUtil.getFullDefinition(routine);
        if (fullDef != null)
          consumer.process(fullDef);
      }
    }
  }
}
