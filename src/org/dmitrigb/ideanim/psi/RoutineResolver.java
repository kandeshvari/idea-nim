package org.dmitrigb.ideanim.psi;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import org.dmitrigb.ideanim.psi.elements.*;
import org.dmitrigb.ideanim.types.TGeneric;
import org.dmitrigb.ideanim.types.TPrimitive;
import org.dmitrigb.ideanim.types.Type;
import org.dmitrigb.ideanim.types.Types;
import org.jetbrains.annotations.NotNull;

public class RoutineResolver extends SymbolResolver {

  enum MatchCategory {
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

  private static class Param {
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
    super(procId.getText(), null);
    this.arguments = arguments;
  }

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (element instanceof RoutineDef)
      match((RoutineDef) element);
    return true;
  }

  private void match(RoutineDef routine) {
    if (!symbolMatches(routine.getName()))
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
      Type paramType = param.type == null ? null : param.type.toType();
      if (paramType == null)
        continue;

      MatchCategory match = matchArgument(arguments.get(i), paramType);
      if (match != null)
        counts.addMatch(match);
    }
    return counts;
  }

  static MatchCategory matchArgument(Expression arg, Type paramType) {
    Type argType = arg.getType();
    if (argType == null)
      return null;

    if (argType.equals(paramType))
      return MatchCategory.EXACT;

    if (arg instanceof Literal && paramType instanceof TPrimitive) {
      Literal lit = (Literal) arg;
      TPrimitive litType = (TPrimitive) argType;
      TPrimitive primType = (TPrimitive) paramType;
      if (litType.isInteger() && primType.isInteger() && primType.isInRange(lit.integerValue(), litType.isUnsignedInteger()))
        return MatchCategory.LITERAL;
    }

    if (paramType instanceof TGeneric)
      // TODO: check constraints
      return MatchCategory.GENERIC;

    if (Types.isSubtype(paramType, argType))
      return MatchCategory.SUBTYPE;

    return null;
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
