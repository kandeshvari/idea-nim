package org.dmitrigb.ideanim.psi;

import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.BaseScopeProcessor;
import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.NotNull;

public abstract class SymbolProcessor extends BaseScopeProcessor {

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (element instanceof TypeDef) {
      if (!processTypeDef((TypeDef) element))
        return false;
      Expression def = ((TypeDef) element).getDefinition();
      if (def instanceof EnumDef)
        for (EnumMember member : ((EnumDef) def).getMembers())
          if (!processEnumMember(member))
            return false;
    }
    else if (element instanceof RoutineDef) {
      if (!processRoutine((RoutineDef) element))
        return false;
    }
    else if (element instanceof ProcResultPsiElement) {
      if (!processRoutineResult((ProcResultPsiElement) element))
        return false;
    }
    else if (element instanceof VarDef) {
      for (IdentPragmaPair pair : ((VarDef) element).getIdentifiers())
        if (!processVar(pair.getIdentifier()))
          return false;
    }
    else if (element instanceof ConstDef) {
      if (!processConst((ConstDef) element))
        return false;
    }
    else if (element instanceof IdentifierDefs) {
      for (IdentPragmaPair pair : ((IdentifierDefs) element).getIdentifiers())
        if (!processParam(pair.getIdentifier()))
          return false;
    }
    else if (element instanceof ForStmt) {
      for (IdentPragmaPair pair : ((ForStmt) element).getIdentPragmaPairList())
        if (!processVar(pair.getIdentifier()))
          return false;
    }
    else if (element instanceof GenericParam) {
      for (IdentifierDef id : ((GenericParam) element).getIdentifers()) {
        if (!processTypeParam(id))
          return false;
      }
    }
    else if (element instanceof ObjectFields) {
      List<IdentPragmaPair> identifiers = ((ObjectFields) element).getIdentifiers();
      for (IdentPragmaPair ipp : identifiers)
        if (!processField(ipp.getIdentifier()))
          return false;
    }
    else if (element instanceof ImportStmt) {
      List<Expression> expressions = ((ImportStmt) element).getExpressionList();
      for (Expression expression : expressions) {
        if (!processImport(expression))
          return false;
      }
    }

    return true;
  }

  protected boolean processImport(Expression expression) { return true; }

  protected boolean processField(IdentifierDef field) {
    return true;
  }

  protected boolean processTypeParam(IdentifierDef typeParam) {
    return true;
  }

  protected boolean processParam(IdentifierDef param) {
    return true;
  }

  protected boolean processConst(ConstDef constDef) {
    return true;
  }

  protected boolean processVar(IdentifierDef var) {
    return true;
  }

  protected boolean processRoutineResult(ProcResultPsiElement result) {
    return true;
  }

  protected boolean processRoutine(RoutineDef routine) {
    return true;
  }

  protected boolean processEnumMember(EnumMember enumMember) {
    return true;
  }

  protected boolean processTypeDef(TypeDef typeDef) {
    return true;
  }
}
