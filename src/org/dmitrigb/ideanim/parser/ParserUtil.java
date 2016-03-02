package org.dmitrigb.ideanim.parser;

import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.lang.impl.PsiBuilderImpl;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.Key;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.containers.IntIntHashMap;

import static org.dmitrigb.ideanim.psi.NimTypes.*;

public class ParserUtil extends GeneratedParserUtilBase {
  private static class ParserState {
    enum PrimaryMode {
      NORMAL, TYPE_DEF, TYPE_DESC
    }

    private PsiBuilder builder;
    private int currentIndent = 0;
    private int pragmaCount = 0;
    private PrimaryMode primaryMode = PrimaryMode.NORMAL;
    private int semiStmtListCount = 0;

    private IntIntHashMap tokIndentCache = new IntIntHashMap();

    ParserState(PsiBuilder builder) {
      this.builder = builder;
    }

    private String getPrecedingWhiteSpace() {
      int wsOffset = 0;
      while (builder.rawLookup(wsOffset - 1) == TokenType.WHITE_SPACE)
        --wsOffset;
      int wsStart = builder.rawTokenTypeStart(wsOffset);
      return builder.getOriginalText().subSequence(wsStart, builder.getCurrentOffset()).toString();
    }

    private String getFollowingWhiteSpace() {
      int nonWsOffset = 1;
      while (builder.rawLookup(nonWsOffset) == TokenType.WHITE_SPACE)
        ++nonWsOffset;
      int nonWsStart = builder.rawTokenTypeStart(nonWsOffset);
      return builder.getOriginalText().subSequence(builder.rawTokenTypeStart(1), nonWsStart).toString();
    }

    int getSpacesLeft() {
      return getPrecedingWhiteSpace().length();
    }

    int getSpacesRight() {
      return getFollowingWhiteSpace().length();
    }

    int getTokenIndent() {
      int tokStart = builder.getCurrentOffset();
      if (tokIndentCache.containsKey(tokStart))
        return tokIndentCache.get(tokStart);

      int indent = -1;
      String ws = getPrecedingWhiteSpace();
      int nlPos = ws.lastIndexOf('\n');
      if (nlPos != -1)
        indent = ws.length() - nlPos - 1;
      tokIndentCache.put(tokStart, indent);
      return indent;
    }
  }

  private static Key<ParserState> parserStateKey = new Key<>("parser-state");

  private static ParserState getParserState(PsiBuilder builder) {
    return builder.getUserData(parserStateKey);
  }

  public static boolean indented(PsiBuilder builder, int l, Parser parser) {
    ParserState state = getParserState(builder);
    int tokIndent = state.getTokenIndent();
    if (tokIndent > state.currentIndent) {
      int prevIndent = state.currentIndent;
      state.currentIndent = tokIndent;
      boolean result = parser.parse(builder, l + 1);
      state.currentIndent = prevIndent;
      return result;
    }
    return false;
  }

  public static boolean indEq(PsiBuilder builder, int l) {
    ParserState state = getParserState(builder);
    return state.getTokenIndent() == state.currentIndent;
  }

  public static boolean indLt(PsiBuilder builder, int l) {
    ParserState state = getParserState(builder);
    int tokenIndent = state.getTokenIndent();
    return tokenIndent >= 0 && tokenIndent < state.currentIndent;
  }

  public static boolean indGt(PsiBuilder builder, int l) {
    ParserState state = getParserState(builder);
    return state.getTokenIndent() > state.currentIndent;
  }

  public static boolean indNone(PsiBuilder builder, int l) {
    ParserState state = getParserState(builder);
    return state.getTokenIndent() == -1;
  }

  public static boolean indOpt(PsiBuilder builder, int l) {
    ParserState state = getParserState(builder);
    int tokInd = state.getTokenIndent();
    return tokInd == -1 || tokInd > state.currentIndent;
  }

  public static boolean enterPragma(PsiBuilder builder, int l, Parser parser) {
    ParserState state = getParserState(builder);
    state.pragmaCount++;
    boolean result = parser.parse(builder, l + 1);
    state.pragmaCount--;
    return result;
  }

  public static boolean typeDefMode(PsiBuilder builder, int level, Parser parser) {
    ParserState state = getParserState(builder);
    ParserState.PrimaryMode prevMode = state.primaryMode;
    state.primaryMode = ParserState.PrimaryMode.TYPE_DEF;
    boolean result = parser.parse(builder, level + 1);
    state.primaryMode = prevMode;
    return result;
  }

  public static boolean typeDescMode(PsiBuilder builder, int level, Parser parser) {
    ParserState state = getParserState(builder);
    ParserState.PrimaryMode prevMode = state.primaryMode;
    state.primaryMode = ParserState.PrimaryMode.TYPE_DESC;
    boolean result = parser.parse(builder, level + 1);
    state.primaryMode = prevMode;
    return result;
  }

  public static boolean inNormalMode(PsiBuilder builder, int level) {
    ParserState state = getParserState(builder);
    return state.primaryMode == ParserState.PrimaryMode.NORMAL;
  }

  public static boolean inTypeDefMode(PsiBuilder builder, int level) {
    ParserState state = getParserState(builder);
    return state.primaryMode == ParserState.PrimaryMode.TYPE_DEF;
  }

  public static PsiBuilder adapt_builder_(IElementType root, PsiBuilder builder, PsiParser parser, TokenSet[] extendsSets) {
    PsiBuilder psiBuilder = GeneratedParserUtilBase.adapt_builder_(root, builder, parser, extendsSets);
    //System.out.println("Adapting the builder, creating new parser state");

    ParserState state = new ParserState(psiBuilder);
    psiBuilder.putUserData(parserStateKey, state);

    return psiBuilder;
  }

  public static boolean extendCommand(PsiBuilder builder, int level, Parser children) {
    LighterASTNode leftNode = builder.getLatestDoneMarker();
    if (leftNode.getTokenType() != COMMAND_EXPR)
      return false;
    PsiBuilderImpl.Marker left = (PsiBuilderImpl.Marker) leftNode;
    PsiBuilder.Marker newMarker = left.precede();
    boolean result = children.parse(builder, level + 1);
    if (result) {
      left.drop();
      newMarker.done(COMMAND_EXPR);
    }
    else
      newMarker.drop();

    return result;
  }

  public static boolean parseSimpleExpr(PsiBuilder builder, int level, Parser primary, int limit) {
    PsiBuilder.Marker marker = builder.mark();
    if (!primary.parse(builder, level + 1)) {
      marker.drop();
      return false;
    }
    return parseOperators(builder, level + 1, primary, marker, limit);
  }

  private static boolean parseOperators(PsiBuilder builder, int level, Parser primary, PsiBuilder.Marker headMarker, int limit) {
    int opPrec = getPrecedence(builder.getTokenType(), builder.getTokenText());
    ParserState state = getParserState(builder);

    ParserState.PrimaryMode mode = state.primaryMode;
    state.primaryMode = mode == ParserState.PrimaryMode.TYPE_DEF ? ParserState.PrimaryMode.TYPE_DESC : mode;
    try {
      while (opPrec >= limit && state.getTokenIndent() < 0 && !isUnary(builder)) {
        int leftAssoc = isRightAssociative(builder.getTokenType(), builder.getTokenText()) ? 0 : 1;
        builder.advanceLexer();
        boolean r = indOpt(builder, limit + 1);
        if (r) r = parseSimpleExpr(builder, level + 1, primary, opPrec + leftAssoc);
        if (r) {
          headMarker.done(INFIX_EXPR);
          headMarker = headMarker.precede();
        }
        else {
          headMarker.drop();
          return false;
        }
        opPrec = getPrecedence(builder.getTokenType(), builder.getTokenText());
      }
      headMarker.drop();
      return true;
    }
    finally {
      state.primaryMode = mode;
    }
  }

  private static boolean isRightAssociative(IElementType tokType, String tokText) {
    return tokType == OPERATOR && tokText.startsWith("^");
  }

  private static boolean isUnary(PsiBuilder builder) {
    if (builder.getTokenType() == OPERATOR || builder.getTokenType() == T_DOTDOT) {
      ParserState state = getParserState(builder);
      if (state.getSpacesLeft() > 0 && state.getSpacesRight() == 0)
        return true;
    }
    return false;
  }

  private static int getPrecedence(IElementType tokType, String tokText) {
    if (tokType == OPERATOR) {
      if (tokText.endsWith("->") || tokText.endsWith("~>") || tokText.endsWith("=>"))
        return 1;

      char relevantChar = tokText.charAt(0);
      boolean assignment = tokText.endsWith("=");

      switch (relevantChar) {
        case '$':
        case '^':
          return assignment ? 1 : 10;
        case '*':
        case '%':
        case '/':
        case '\\':
          return assignment ? 1 : 9;
        case '~':
          return 8;
        case '+':
        case '-':
        case '|':
          return assignment ? 1 : 8;
        case '&':
          return assignment ? 1 : 7;
        case '=':
        case '<':
        case '>':
        case '!':
          return 5;
        case '.':
          return assignment ? 1 : 6;
        case '?':
          return 2;
        default:
          return assignment ? 1 : 2;
      }
    }
    else if (tokType == T_DIV || tokType == T_MOD || tokType == T_SHL || tokType == T_SHR)
      return 9;
    else if (tokType == T_IN || tokType == T_NOTIN || tokType == T_IS || tokType == T_ISNOT || tokType == T_NOT || tokType == T_OF || tokType == T_AS)
      return 5;
    else if (tokType == T_DOTDOT)
      return 6;
    else if (tokType == T_AND)
      return 4;
    else if (tokType == T_OR || tokType == T_XOR || tokType == T_PTR || tokType == T_REF)
      return 3;

    return -10;
  }

  public static boolean arrow(PsiBuilder builder, int level) {
    if (builder.getTokenType() == OPERATOR && "->".equals(builder.getTokenText())) {
      builder.advanceLexer();
      return true;
    }
    return false;
  }

  public static boolean enterSemiStmtList(PsiBuilder builder, int level, Parser parser) {
    ParserState state = getParserState(builder);
    state.semiStmtListCount++;
    boolean result = parser.parse(builder, level);
    state.semiStmtListCount--;
    return result;
  }

  public static boolean inSemiStmtList(PsiBuilder builder, int level) {
    return getParserState(builder).semiStmtListCount > 0;
  }
}
