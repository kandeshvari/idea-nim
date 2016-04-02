package org.dmitrigb.ideanim.psi;

import java.util.List;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.util.Computable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.BaseScopeProcessor;
import org.dmitrigb.ideanim.NimIdentifierUtil;
import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.NotNull;

public class SymbolResolver extends BaseScopeProcessor {

  private Identifier source;
  private String sourceId;
  private boolean typesOnly = false;
  private boolean fullDefinitionOnly = false;

  private PsiElement target;

  public SymbolResolver(Identifier source) {
    this.source = source;
    String sourceText = ApplicationManager.getApplication().runReadAction((Computable<String>) this.source::getText);
    sourceId = NimIdentifierUtil.normalizeId(sourceText);
  }

  public void setTypesOnly(boolean typesOnly) {
    this.typesOnly = typesOnly;
  }

  public void setFullDefinitionOnly(boolean fullDefinitionOnly) {
    this.fullDefinitionOnly = fullDefinitionOnly;
  }

  private boolean symbolMatches(Identifier symbol) {
    String symbolText = ApplicationManager.getApplication().runReadAction((Computable<String>) symbol::getText);
    return NimIdentifierUtil.normalizeId(symbolText).equals(sourceId);
  }

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (element instanceof TypeDef) {
      Identifier id = ((TypeDef) element).getIdentifier();
      if (symbolMatches(id)) {
        target = element;
        return false;
      }
    }

    if (typesOnly)
      return true;

    if (element instanceof RoutineDef) {
      RoutineDef routine = (RoutineDef) element;
      Identifier symbol = routine.getIdentifier();
      if (symbol != null && symbolMatches(symbol)) {
        if (!(fullDefinitionOnly && routine.isForwardDeclaration())) {
          target = element;
          return false;
        }
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
