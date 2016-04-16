package org.dmitrigb.ideanim.psi;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import org.dmitrigb.ideanim.psi.elements.*;
import org.dmitrigb.ideanim.types.TGeneric;
import org.dmitrigb.ideanim.types.TObject;
import org.dmitrigb.ideanim.types.TPrimitive;
import org.dmitrigb.ideanim.types.Type;
import org.dmitrigb.ideanim.types.Types;
import org.jetbrains.annotations.NotNull;

public class RoutineResolver extends SymbolResolver {

  private enum MatchCategory {
    EXACT, LITERAL, GENERIC, SUBTYPE, INTEGRAL, CONVERSION
  }

  private static class MatchCounts {
    private EnumMap<MatchCategory, Integer> counts = new EnumMap<>(MatchCategory.class);

    public void addMatch(MatchCategory category) {
      counts.merge(category, 1, (a, b) -> a + b);
    }

    public boolean isBetterThan(MatchCounts other) {
      for (MatchCategory category : MatchCategory.values()) {
        int myCount = counts.getOrDefault(category, 0);
        int otherCount = other.counts.getOrDefault(category, 0);
        if (myCount > otherCount)
          return true;
        if (myCount == otherCount)
          continue;
        return false; // myCount < otherCount
      }
      return false; // ambiguous, all categories have equal count
    }
  }

  private class Param {
    IdentifierDef id;
    Pragma pragma;
    TypeDesc type;
    Expression initializer;

    public Param(IdentifierDef id, Pragma pragma, TypeDesc type, Expression initializer) {
      this.id = id;
      this.pragma = pragma;
      this.type = type;
      this.initializer = initializer;
    }
  }

  private List<Expression> arguments;
  private RoutineDef nameMatch;
  private RoutineDef argCountMatch;
  private RoutineDef fullMatch;
  private MatchCounts bestCounts;

  public RoutineResolver(Identifier procId, List<Expression> arguments) {
    super(procId);
    this.arguments = arguments;
  }

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (element instanceof RoutineDef)
      match((RoutineDef) element);
    return true;
  }

  private void match(RoutineDef routine) {
    if (!symbolMatches(routine.getIdentifier()))
      return;

    if (nameMatch == null)
      nameMatch = routine;

    List<Param> params = new ArrayList<>();
    for (IdentifierDefs idDefs : routine.getParameters()) {
      params.addAll(idDefs.getIdentifiers().stream()
          .map(ipp -> new Param(ipp.getIdentifier(), ipp.getPragma(), idDefs.getDeclaredType(), idDefs.getInitializer()))
          .collect(Collectors.toList()));
    }

    if (params.size() != arguments.size())
      return;

    if (argCountMatch == null)
      argCountMatch = routine;

    MatchCounts counts = getMatchCounts(params);
    if (counts == null)
      return;

    if (bestCounts == null || counts.isBetterThan(bestCounts)) {
      fullMatch = routine;
      bestCounts = counts;
    }
  }

  private MatchCounts getMatchCounts(List<Param> params) {
    MatchCounts counts = new MatchCounts();
    for (int i = 0; i < params.size(); i++) {
      Param param = params.get(i);
      Expression arg = arguments.get(i);
      Type paramType = param.type == null ? null : param.type.toType();
      Type argType = arg.getType();

      if (paramType == null || argType == null)
        continue;

      if (argType.equals(paramType)) {
        counts.addMatch(MatchCategory.EXACT);
        continue;
      }

      if (arg instanceof Literal && paramType instanceof TPrimitive) {
        Literal lit = (Literal) arg;
        TPrimitive litType = (TPrimitive) argType;
        TPrimitive primType = (TPrimitive) paramType;
        if (litType.isInteger() && primType.isInteger() && primType.isInRange(lit.integerValue(), litType.isUnsignedInteger())) {
          counts.addMatch(MatchCategory.LITERAL);
          continue;
        }
      }

      if (paramType instanceof TGeneric) {
        // TODO: check constraints
        counts.addMatch(MatchCategory.GENERIC);
        continue;
      }

      if (Types.isSubtype(paramType, argType)) {
        counts.addMatch(MatchCategory.SUBTYPE);
        continue;
      }
    }
    return counts;
  }

  @Override
  public PsiElement getResolvedTarget() {
    if (fullMatch != null)
      return fullMatch;
    if (argCountMatch != null)
      return argCountMatch;
    return nameMatch;
  }
}
