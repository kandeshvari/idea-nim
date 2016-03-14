package org.dmitrigb.ideanim.psi;

import java.util.List;

import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.NotNull;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.BaseScopeProcessor;

import static org.dmitrigb.ideanim.ResolveStateKeys.IN_UNREACHABLE_SCOPE;

public class SymbolResolver extends BaseScopeProcessor {

  private Identifier source;
  private String sourceId;

  private PsiElement target;

  public SymbolResolver(Identifier source) {
    this.source = source;
    sourceId = normalizeId(this.source.getText());
  }

  private String normalizeId(String identifier) {
    return identifier.charAt(0) + identifier.substring(1).replace("_", "").replace("\u2013", "").toLowerCase();
  }

  private boolean symbolMatches(Identifier symbol) {
    return normalizeId(symbol.getText()).equals(sourceId);
  }

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (target == null && state.get(IN_UNREACHABLE_SCOPE))
      return false;

    if (element instanceof RoutineDef) {
      RoutineDef routine = (RoutineDef) element;
      Identifier symbol = routine.getIdentifier();
      if (symbol != null && symbolMatches(symbol)) {
        target = element;
        if (routine.getBody() != null)
          return false;
      }
    }
    else if (element instanceof ProcResultPsiElement) {
      if (sourceId.equals("result")) {
        target = element;
        return false;
      }
    }
    else if (element instanceof VarDef) {
      VarDef def = (VarDef) element;
      List<IdentPragmaPair> symbols = def.getIdentifiers();
      for (IdentPragmaPair pair : symbols) {
        if (symbolMatches(pair.getIdentifier())) {
          target = pair.getIdentifier();
          return false;
        }
      }
    }
    else if (element instanceof ConstDef) {
      ConstDef def = (ConstDef) element;
      Identifier symbol = def.getIdentifier();
      if (symbolMatches(symbol)) {
        target = element;
        return false;
      }
    }
    else if (element instanceof IdentifierDefs) {
      IdentifierDefs def = (IdentifierDefs) element;
      List<IdentPragmaPair> pairs = def.getIdentifiers();
      for (IdentPragmaPair pair : pairs) {
        if (symbolMatches(pair.getIdentifier())) {
          target = pair.getIdentifier();
          return false;
        }
      }
    }

    return true;
  }

  public PsiElement getResolvedTarget() {
    return target;
  }
}
