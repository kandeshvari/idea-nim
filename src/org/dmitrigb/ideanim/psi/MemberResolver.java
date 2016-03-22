package org.dmitrigb.ideanim.psi;

import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.BaseScopeProcessor;
import org.dmitrigb.ideanim.NimIdentifierUtil;
import org.dmitrigb.ideanim.psi.elements.IdentPragmaPair;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.ObjectFields;
import org.jetbrains.annotations.NotNull;

public class MemberResolver extends BaseScopeProcessor {

  private String sourceId;
  private Identifier target;

  public MemberResolver(Identifier identifier) {
    sourceId = NimIdentifierUtil.normalizeId(identifier.getText());
  }

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (element instanceof ObjectFields) {
      List<IdentPragmaPair> identifiers = ((ObjectFields) element).getIdentifiers();
      for (IdentPragmaPair ipp : identifiers) {
        if (symbolMatches(ipp.getIdentifier())) {
          target = ipp.getIdentifier();
          return false;
        }
      }
    }
    return true;
  }

  private boolean symbolMatches(Identifier symbol) {
    return NimIdentifierUtil.normalizeId(symbol.getText()).equals(sourceId);
  }

  public Identifier getResolvedTarget() {
    return target;
  }
}
