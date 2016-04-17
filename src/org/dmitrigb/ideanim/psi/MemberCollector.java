package org.dmitrigb.ideanim.psi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.BaseScopeProcessor;
import org.dmitrigb.ideanim.psi.elements.IdentPragmaPair;
import org.dmitrigb.ideanim.psi.elements.IdentifierDef;
import org.dmitrigb.ideanim.psi.elements.ObjectFields;
import org.jetbrains.annotations.NotNull;

public class MemberCollector extends BaseScopeProcessor {

  private List<IdentifierDef> candidates = new ArrayList<>();

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (element instanceof ObjectFields) {
      List<IdentPragmaPair> identifiers = ((ObjectFields) element).getIdentifiers();
      candidates.addAll(identifiers.stream().map(IdentPragmaPair::getIdentifier).collect(Collectors.toList()));
    }
    return true;
  }

  public List<IdentifierDef> getCandidates() {
    return candidates;
  }
}
