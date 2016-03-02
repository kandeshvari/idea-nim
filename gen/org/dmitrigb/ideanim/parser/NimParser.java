// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.dmitrigb.ideanim.psi.NimTypesBase.*;
import static org.dmitrigb.ideanim.parser.ParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NimParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ASSIGNMENT_EXPR) {
      r = AssignmentExpr(b, 0);
    }
    else if (t == BLOCK_STMT) {
      r = BlockStmt(b, 0);
    }
    else if (t == BRACKET_CTOR) {
      r = BracketCtor(b, 0);
    }
    else if (t == BRACKET_EXPR) {
      r = BracketExpr(b, 0);
    }
    else if (t == BREAK_STMT) {
      r = BreakStmt(b, 0);
    }
    else if (t == CALL_EXPR) {
      r = CallExpr(b, 0);
    }
    else if (t == CASE_EXPR) {
      r = CaseExpr(b, 0);
    }
    else if (t == CASE_STMT) {
      r = CaseStmt(b, 0);
    }
    else if (t == CAST_EXPR) {
      r = CastExpr(b, 0);
    }
    else if (t == COMMAND_EXPR) {
      r = CommandExpr(b, 0);
    }
    else if (t == CONST_DEF) {
      r = ConstDef(b, 0);
    }
    else if (t == CONST_SECT) {
      r = ConstSect(b, 0);
    }
    else if (t == DISCARD_STMT) {
      r = DiscardStmt(b, 0);
    }
    else if (t == DO_BLOCK) {
      r = DoBlock(b, 0);
    }
    else if (t == DOT_EXPR) {
      r = DotExpr(b, 0);
    }
    else if (t == ENUM_DEF) {
      r = EnumDef(b, 0);
    }
    else if (t == EXPR_STMT) {
      r = ExprStmt(b, 0);
    }
    else if (t == FOR_STMT) {
      r = ForStmt(b, 0);
    }
    else if (t == GENERIC_PARAM_LIST) {
      r = GenericParamList(b, 0);
    }
    else if (t == GROUPED_EXPR) {
      r = GroupedExpr(b, 0);
    }
    else if (t == IDENTIFIER) {
      r = Identifier(b, 0);
    }
    else if (t == IF_EXPR) {
      r = IfExpr(b, 0);
    }
    else if (t == IF_STMT) {
      r = IfStmt(b, 0);
    }
    else if (t == IMPORT_STMT) {
      r = ImportStmt(b, 0);
    }
    else if (t == INFIX_EXPR) {
      r = InfixExpr(b, 0);
    }
    else if (t == ITERATOR_DEF) {
      r = IteratorDef(b, 0);
    }
    else if (t == LET_SECT) {
      r = LetSect(b, 0);
    }
    else if (t == LITERAL) {
      r = Literal(b, 0);
    }
    else if (t == NIL_TOKEN) {
      r = NilToken(b, 0);
    }
    else if (t == OBJECT_DEF) {
      r = ObjectDef(b, 0);
    }
    else if (t == PARAM_LIST) {
      r = ParamList(b, 0);
    }
    else if (t == PATTERN) {
      r = Pattern(b, 0);
    }
    else if (t == PRAGMA) {
      r = Pragma(b, 0);
    }
    else if (t == PRAGMA_STMT) {
      r = PragmaStmt(b, 0);
    }
    else if (t == PREFIX_EXPR) {
      r = PrefixExpr(b, 0);
    }
    else if (t == PROC_DEF) {
      r = ProcDef(b, 0);
    }
    else if (t == RAISE_STMT) {
      r = RaiseStmt(b, 0);
    }
    else if (t == RETURN_STMT) {
      r = ReturnStmt(b, 0);
    }
    else if (t == ROUTINE_BODY) {
      r = RoutineBody(b, 0);
    }
    else if (t == SET_OR_TABLE_CTOR) {
      r = SetOrTableCtor(b, 0);
    }
    else if (t == SYMBOL) {
      r = Symbol(b, 0);
    }
    else if (t == TEMPLATE_DEF) {
      r = TemplateDef(b, 0);
    }
    else if (t == TRY_STMT) {
      r = TryStmt(b, 0);
    }
    else if (t == TYPE_DEF) {
      r = TypeDef(b, 0);
    }
    else if (t == TYPE_DESC) {
      r = TypeDesc(b, 0);
    }
    else if (t == TYPE_SECT) {
      r = TypeSect(b, 0);
    }
    else if (t == VAR_DEF) {
      r = VarDef(b, 0);
    }
    else if (t == VAR_SECT) {
      r = VarSect(b, 0);
    }
    else if (t == WHEN_EXPR) {
      r = WhenExpr(b, 0);
    }
    else if (t == WHEN_STMT) {
      r = WhenStmt(b, 0);
    }
    else if (t == WHILE_STMT) {
      r = WhileStmt(b, 0);
    }
    else if (t == YIELD_STMT) {
      r = YieldStmt(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return NimFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ITERATOR_DEF, PROC_DEF, TEMPLATE_DEF),
    create_token_set_(ASSIGNMENT_EXPR, BRACKET_CTOR, BRACKET_EXPR, CALL_EXPR,
      CASE_EXPR, CAST_EXPR, COMMAND_EXPR, DOT_EXPR,
      GROUPED_EXPR, IDENTIFIER, IF_EXPR, INFIX_EXPR,
      LITERAL, NIL_TOKEN, PREFIX_EXPR, SET_OR_TABLE_CTOR,
      WHEN_EXPR),
    create_token_set_(BLOCK_STMT, BREAK_STMT, CASE_STMT, CONST_SECT,
      DISCARD_STMT, EXPR_STMT, FOR_STMT, IF_STMT,
      IMPORT_STMT, ITERATOR_DEF, LET_SECT, PRAGMA_STMT,
      PROC_DEF, RAISE_STMT, RETURN_STMT, TEMPLATE_DEF,
      TYPE_SECT, VAR_SECT, WHEN_STMT, WHILE_STMT,
      YIELD_STMT),
  };

  /* ********************************************************** */
  // T_EQ OPTIND expr
  public static boolean AssignmentExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentExpr")) return false;
    if (!nextTokenIs(b, T_EQ)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, T_EQ);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, ASSIGNMENT_EXPR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_BLOCK INDNONE Symbol? T_COLON stmt
  public static boolean BlockStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockStmt")) return false;
    if (!nextTokenIs(b, T_BLOCK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_BLOCK);
    p = r; // pin = 1
    r = r && report_error_(b, indNone(b, l + 1));
    r = p && report_error_(b, BlockStmt_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, T_COLON)) && r;
    r = p && stmt(b, l + 1) && r;
    exit_section_(b, l, m, BLOCK_STMT, r, p, null);
    return r || p;
  }

  // Symbol?
  private static boolean BlockStmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockStmt_2")) return false;
    Symbol(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // T_LBRACKET exprColonEqExprList T_RBRACKET
  public static boolean BracketCtor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BracketCtor")) return false;
    if (!nextTokenIs(b, T_LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, exprColonEqExprList(b, l + 1));
    r = p && consumeToken(b, T_RBRACKET) && r;
    exit_section_(b, l, m, BRACKET_CTOR, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_LBRACKET exprColonEqExprList T_RBRACKET
  public static boolean BracketExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BracketExpr")) return false;
    if (!nextTokenIs(b, T_LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, T_LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, exprColonEqExprList(b, l + 1));
    r = p && consumeToken(b, T_RBRACKET) && r;
    exit_section_(b, l, m, BRACKET_EXPR, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_BREAK (OPTIND &isExprStart expr)?
  public static boolean BreakStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStmt")) return false;
    if (!nextTokenIs(b, T_BREAK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_BREAK);
    p = r; // pin = 1
    r = r && BreakStmt_1(b, l + 1);
    exit_section_(b, l, m, BREAK_STMT, r, p, null);
    return r || p;
  }

  // (OPTIND &isExprStart expr)?
  private static boolean BreakStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStmt_1")) return false;
    BreakStmt_1_0(b, l + 1);
    return true;
  }

  // OPTIND &isExprStart expr
  private static boolean BreakStmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && BreakStmt_1_0_1(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &isExprStart
  private static boolean BreakStmt_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStmt_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = isExprStart(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_LPAREN exprColonEqExprList T_RPAREN doBlocks
  public static boolean CallExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpr")) return false;
    if (!nextTokenIs(b, T_LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, T_LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, exprColonEqExprList(b, l + 1));
    r = p && report_error_(b, consumeToken(b, T_RPAREN)) && r;
    r = p && doBlocks(b, l + 1) && r;
    exit_section_(b, l, m, CALL_EXPR, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // caseStmtOrExpr
  public static boolean CaseExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseExpr")) return false;
    if (!nextTokenIs(b, T_CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caseStmtOrExpr(b, l + 1);
    exit_section_(b, m, CASE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // caseStmtOrExpr
  public static boolean CaseStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseStmt")) return false;
    if (!nextTokenIs(b, T_CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caseStmtOrExpr(b, l + 1);
    exit_section_(b, m, CASE_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // T_CAST T_LBRACKET OPTIND TypeDesc T_RBRACKET T_LPAREN OPTIND expr T_RPAREN
  public static boolean CastExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CastExpr")) return false;
    if (!nextTokenIs(b, T_CAST)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 1, T_CAST, T_LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, indOpt(b, l + 1));
    r = p && report_error_(b, TypeDesc(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, T_RBRACKET, T_LPAREN)) && r;
    r = p && report_error_(b, indOpt(b, l + 1)) && r;
    r = p && report_error_(b, expr(b, l + 1)) && r;
    r = p && consumeToken(b, T_RPAREN) && r;
    exit_section_(b, l, m, CAST_EXPR, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // &(IDENT | Literal | ACCENT_QUOTED | T_NIL | T_CAST | T_ADDR | T_TYPE) expr
  public static boolean CommandExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<command expr>");
    r = CommandExpr_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, COMMAND_EXPR, r, false, null);
    return r;
  }

  // &(IDENT | Literal | ACCENT_QUOTED | T_NIL | T_CAST | T_ADDR | T_TYPE)
  private static boolean CommandExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = CommandExpr_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // IDENT | Literal | ACCENT_QUOTED | T_NIL | T_CAST | T_ADDR | T_TYPE
  private static boolean CommandExpr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CommandExpr_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    if (!r) r = Literal(b, l + 1);
    if (!r) r = consumeToken(b, ACCENT_QUOTED);
    if (!r) r = consumeToken(b, T_NIL);
    if (!r) r = consumeToken(b, T_CAST);
    if (!r) r = consumeToken(b, T_ADDR);
    if (!r) r = consumeToken(b, T_TYPE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identWithPragma (T_COLON OPTIND TypeDesc)? T_EQ OPTIND expr
  public static boolean ConstDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<const def>");
    r = identWithPragma(b, l + 1);
    r = r && ConstDef_1(b, l + 1);
    r = r && consumeToken(b, T_EQ);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, CONST_DEF, r, false, null);
    return r;
  }

  // (T_COLON OPTIND TypeDesc)?
  private static boolean ConstDef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDef_1")) return false;
    ConstDef_1_0(b, l + 1);
    return true;
  }

  // T_COLON OPTIND TypeDesc
  private static boolean ConstDef_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstDef_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && indOpt(b, l + 1);
    r = r && TypeDesc(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_CONST <<section ConstDef>>
  public static boolean ConstSect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstSect")) return false;
    if (!nextTokenIs(b, T_CONST)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_CONST);
    p = r; // pin = 1
    r = r && section(b, l + 1, ConstDef_parser_);
    exit_section_(b, l, m, CONST_SECT, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_DISCARD (OPTIND &isExprStart expr)?
  public static boolean DiscardStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DiscardStmt")) return false;
    if (!nextTokenIs(b, T_DISCARD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_DISCARD);
    p = r; // pin = 1
    r = r && DiscardStmt_1(b, l + 1);
    exit_section_(b, l, m, DISCARD_STMT, r, p, null);
    return r || p;
  }

  // (OPTIND &isExprStart expr)?
  private static boolean DiscardStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DiscardStmt_1")) return false;
    DiscardStmt_1_0(b, l + 1);
    return true;
  }

  // OPTIND &isExprStart expr
  private static boolean DiscardStmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DiscardStmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && DiscardStmt_1_0_1(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &isExprStart
  private static boolean DiscardStmt_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DiscardStmt_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = isExprStart(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_DO paramListArrow (OPTIND Pragma)? T_COLON stmt
  public static boolean DoBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DoBlock")) return false;
    if (!nextTokenIs(b, T_DO)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_DO);
    p = r; // pin = 1
    r = r && report_error_(b, paramListArrow(b, l + 1));
    r = p && report_error_(b, DoBlock_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, T_COLON)) && r;
    r = p && stmt(b, l + 1) && r;
    exit_section_(b, l, m, DO_BLOCK, r, p, null);
    return r || p;
  }

  // (OPTIND Pragma)?
  private static boolean DoBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DoBlock_2")) return false;
    DoBlock_2_0(b, l + 1);
    return true;
  }

  // OPTIND Pragma
  private static boolean DoBlock_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DoBlock_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && Pragma(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_DOT OPTIND Symbol
  public static boolean DotExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DotExpr")) return false;
    if (!nextTokenIs(b, T_DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, T_DOT);
    p = r; // pin = 1
    r = r && report_error_(b, indOpt(b, l + 1));
    r = p && Symbol(b, l + 1) && r;
    exit_section_(b, l, m, DOT_EXPR, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_ENUM (&OPTIND Symbol (&INDNONE T_EQ &OPTIND expr)? (&INDNONE T_COMMA)?)*
  public static boolean EnumDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef")) return false;
    if (!nextTokenIs(b, T_ENUM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_ENUM);
    p = r; // pin = 1
    r = r && EnumDef_1(b, l + 1);
    exit_section_(b, l, m, ENUM_DEF, r, p, null);
    return r || p;
  }

  // (&OPTIND Symbol (&INDNONE T_EQ &OPTIND expr)? (&INDNONE T_COMMA)?)*
  private static boolean EnumDef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!EnumDef_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EnumDef_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // &OPTIND Symbol (&INDNONE T_EQ &OPTIND expr)? (&INDNONE T_COMMA)?
  private static boolean EnumDef_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EnumDef_1_0_0(b, l + 1);
    r = r && Symbol(b, l + 1);
    r = r && EnumDef_1_0_2(b, l + 1);
    r = r && EnumDef_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &OPTIND
  private static boolean EnumDef_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (&INDNONE T_EQ &OPTIND expr)?
  private static boolean EnumDef_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef_1_0_2")) return false;
    EnumDef_1_0_2_0(b, l + 1);
    return true;
  }

  // &INDNONE T_EQ &OPTIND expr
  private static boolean EnumDef_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EnumDef_1_0_2_0_0(b, l + 1);
    r = r && consumeToken(b, T_EQ);
    r = r && EnumDef_1_0_2_0_2(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean EnumDef_1_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef_1_0_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &OPTIND
  private static boolean EnumDef_1_0_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef_1_0_2_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (&INDNONE T_COMMA)?
  private static boolean EnumDef_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef_1_0_3")) return false;
    EnumDef_1_0_3_0(b, l + 1);
    return true;
  }

  // &INDNONE T_COMMA
  private static boolean EnumDef_1_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef_1_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EnumDef_1_0_3_0_0(b, l + 1);
    r = r && consumeToken(b, T_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean EnumDef_1_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDef_1_0_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // simpleExpr (AssignmentExpr | &INDNONE <<extendCommand (T_COMMA OPTIND expr)+>>? (&T_DO doBlocks | macroColon)? )?
  public static boolean ExprStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<expr stmt>");
    r = parseSimpleExpr(b, l + 1, primary_parser_, 0);
    r = r && ExprStmt_1(b, l + 1);
    exit_section_(b, l, m, EXPR_STMT, r, false, null);
    return r;
  }

  // (AssignmentExpr | &INDNONE <<extendCommand (T_COMMA OPTIND expr)+>>? (&T_DO doBlocks | macroColon)? )?
  private static boolean ExprStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1")) return false;
    ExprStmt_1_0(b, l + 1);
    return true;
  }

  // AssignmentExpr | &INDNONE <<extendCommand (T_COMMA OPTIND expr)+>>? (&T_DO doBlocks | macroColon)?
  private static boolean ExprStmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignmentExpr(b, l + 1);
    if (!r) r = ExprStmt_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE <<extendCommand (T_COMMA OPTIND expr)+>>? (&T_DO doBlocks | macroColon)?
  private static boolean ExprStmt_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExprStmt_1_0_1_0(b, l + 1);
    r = r && ExprStmt_1_0_1_1(b, l + 1);
    r = r && ExprStmt_1_0_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean ExprStmt_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // <<extendCommand (T_COMMA OPTIND expr)+>>?
  private static boolean ExprStmt_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1_0_1_1")) return false;
    extendCommand(b, l + 1, ExprStmt_1_0_1_1_0_0_parser_);
    return true;
  }

  // (T_COMMA OPTIND expr)+
  private static boolean ExprStmt_1_0_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1_0_1_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExprStmt_1_0_1_1_0_0_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!ExprStmt_1_0_1_1_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExprStmt_1_0_1_1_0_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COMMA OPTIND expr
  private static boolean ExprStmt_1_0_1_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1_0_1_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (&T_DO doBlocks | macroColon)?
  private static boolean ExprStmt_1_0_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1_0_1_2")) return false;
    ExprStmt_1_0_1_2_0(b, l + 1);
    return true;
  }

  // &T_DO doBlocks | macroColon
  private static boolean ExprStmt_1_0_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1_0_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExprStmt_1_0_1_2_0_0(b, l + 1);
    if (!r) r = macroColon(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &T_DO doBlocks
  private static boolean ExprStmt_1_0_1_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1_0_1_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExprStmt_1_0_1_2_0_0_0(b, l + 1);
    r = r && doBlocks(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &T_DO
  private static boolean ExprStmt_1_0_1_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExprStmt_1_0_1_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, T_DO);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_FOR INDNONE <<listOf (OPTIND identWithPragma) (T_COMMA)>> T_IN expr T_COLON stmt
  public static boolean ForStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStmt")) return false;
    if (!nextTokenIs(b, T_FOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_FOR);
    p = r; // pin = 1
    r = r && report_error_(b, indNone(b, l + 1));
    r = p && report_error_(b, listOf(b, l + 1, ForStmt_2_0_parser_, ForStmt_2_1_parser_)) && r;
    r = p && report_error_(b, consumeToken(b, T_IN)) && r;
    r = p && report_error_(b, expr(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, T_COLON)) && r;
    r = p && stmt(b, l + 1) && r;
    exit_section_(b, l, m, FOR_STMT, r, p, null);
    return r || p;
  }

  // OPTIND identWithPragma
  private static boolean ForStmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && identWithPragma(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COMMA)
  private static boolean ForStmt_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStmt_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_LBRACKET OPTIND <<listOf genericParam (T_COMMA | T_SEMICOLON)>>? T_RBRACKET
  public static boolean GenericParamList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericParamList")) return false;
    if (!nextTokenIs(b, T_LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, indOpt(b, l + 1));
    r = p && report_error_(b, GenericParamList_2(b, l + 1)) && r;
    r = p && consumeToken(b, T_RBRACKET) && r;
    exit_section_(b, l, m, GENERIC_PARAM_LIST, r, p, null);
    return r || p;
  }

  // <<listOf genericParam (T_COMMA | T_SEMICOLON)>>?
  private static boolean GenericParamList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericParamList_2")) return false;
    listOf(b, l + 1, genericParam_parser_, GenericParamList_2_0_1_parser_);
    return true;
  }

  // T_COMMA | T_SEMICOLON
  private static boolean GenericParamList_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericParamList_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    if (!r) r = consumeToken(b, T_SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_LPAREN OPTIND (
  //       &parKeyw semiStmtList
  //     | T_SEMICOLON OPTIND semiStmtList
  //     //| stmtPragma
  //     | simpleExpr (T_EQ OPTIND expr (&T_SEMICOLON semiStmtList)? | &T_SEMICOLON semiStmtList | /*colonOrEquals*/ (T_COMMA exprColonEqExpr)* T_COMMA?)
  //     ) T_RPAREN
  public static boolean GroupedExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr")) return false;
    if (!nextTokenIs(b, T_LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, indOpt(b, l + 1));
    r = p && report_error_(b, GroupedExpr_2(b, l + 1)) && r;
    r = p && consumeToken(b, T_RPAREN) && r;
    exit_section_(b, l, m, GROUPED_EXPR, r, p, null);
    return r || p;
  }

  // &parKeyw semiStmtList
  //     | T_SEMICOLON OPTIND semiStmtList
  //     //| stmtPragma
  //     | simpleExpr (T_EQ OPTIND expr (&T_SEMICOLON semiStmtList)? | &T_SEMICOLON semiStmtList | /*colonOrEquals*/ (T_COMMA exprColonEqExpr)* T_COMMA?)
  private static boolean GroupedExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GroupedExpr_2_0(b, l + 1);
    if (!r) r = GroupedExpr_2_1(b, l + 1);
    if (!r) r = GroupedExpr_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &parKeyw semiStmtList
  private static boolean GroupedExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GroupedExpr_2_0_0(b, l + 1);
    r = r && semiStmtList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &parKeyw
  private static boolean GroupedExpr_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = parKeyw(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // T_SEMICOLON OPTIND semiStmtList
  private static boolean GroupedExpr_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SEMICOLON);
    r = r && indOpt(b, l + 1);
    r = r && semiStmtList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // simpleExpr (T_EQ OPTIND expr (&T_SEMICOLON semiStmtList)? | &T_SEMICOLON semiStmtList | /*colonOrEquals*/ (T_COMMA exprColonEqExpr)* T_COMMA?)
  private static boolean GroupedExpr_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseSimpleExpr(b, l + 1, primary_parser_, 0);
    r = r && GroupedExpr_2_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_EQ OPTIND expr (&T_SEMICOLON semiStmtList)? | &T_SEMICOLON semiStmtList | /*colonOrEquals*/ (T_COMMA exprColonEqExpr)* T_COMMA?
  private static boolean GroupedExpr_2_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GroupedExpr_2_2_1_0(b, l + 1);
    if (!r) r = GroupedExpr_2_2_1_1(b, l + 1);
    if (!r) r = GroupedExpr_2_2_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_EQ OPTIND expr (&T_SEMICOLON semiStmtList)?
  private static boolean GroupedExpr_2_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EQ);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && GroupedExpr_2_2_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (&T_SEMICOLON semiStmtList)?
  private static boolean GroupedExpr_2_2_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1_0_3")) return false;
    GroupedExpr_2_2_1_0_3_0(b, l + 1);
    return true;
  }

  // &T_SEMICOLON semiStmtList
  private static boolean GroupedExpr_2_2_1_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GroupedExpr_2_2_1_0_3_0_0(b, l + 1);
    r = r && semiStmtList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &T_SEMICOLON
  private static boolean GroupedExpr_2_2_1_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1_0_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, T_SEMICOLON);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &T_SEMICOLON semiStmtList
  private static boolean GroupedExpr_2_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GroupedExpr_2_2_1_1_0(b, l + 1);
    r = r && semiStmtList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &T_SEMICOLON
  private static boolean GroupedExpr_2_2_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, T_SEMICOLON);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (T_COMMA exprColonEqExpr)* T_COMMA?
  private static boolean GroupedExpr_2_2_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GroupedExpr_2_2_1_2_0(b, l + 1);
    r = r && GroupedExpr_2_2_1_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COMMA exprColonEqExpr)*
  private static boolean GroupedExpr_2_2_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1_2_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!GroupedExpr_2_2_1_2_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GroupedExpr_2_2_1_2_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // T_COMMA exprColonEqExpr
  private static boolean GroupedExpr_2_2_1_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && exprColonEqExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COMMA?
  private static boolean GroupedExpr_2_2_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupedExpr_2_2_1_2_1")) return false;
    consumeToken(b, T_COMMA);
    return true;
  }

  /* ********************************************************** */
  // IDENT | T_ADDR | T_TYPE | ACCENT_QUOTED
  public static boolean Identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<identifier>");
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, T_ADDR);
    if (!r) r = consumeToken(b, T_TYPE);
    if (!r) r = consumeToken(b, ACCENT_QUOTED);
    exit_section_(b, l, m, IDENTIFIER, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_IF condExpr
  public static boolean IfExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpr")) return false;
    if (!nextTokenIs(b, T_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IF);
    r = r && condExpr(b, l + 1);
    exit_section_(b, m, IF_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // T_IF &OPTIND condStmt
  public static boolean IfStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStmt")) return false;
    if (!nextTokenIs(b, T_IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_IF);
    p = r; // pin = 1
    r = r && IfStmt_1(b, l + 1);
    r = r && condStmt(b, l + 1);
    exit_section_(b, l, m, IF_STMT, r, p, null);
    return r || p;
  }

  // &OPTIND
  private static boolean IfStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_IMPORT OPTIND expr (T_COMMA OPTIND expr)*
  public static boolean ImportStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStmt")) return false;
    if (!nextTokenIs(b, T_IMPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_IMPORT);
    p = r; // pin = 1
    r = r && report_error_(b, indOpt(b, l + 1));
    r = p && report_error_(b, expr(b, l + 1)) && r;
    r = p && ImportStmt_3(b, l + 1) && r;
    exit_section_(b, l, m, IMPORT_STMT, r, p, null);
    return r || p;
  }

  // (T_COMMA OPTIND expr)*
  private static boolean ImportStmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStmt_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ImportStmt_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImportStmt_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // T_COMMA OPTIND expr
  private static boolean ImportStmt_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStmt_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr
  public static boolean InfixExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InfixExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<infix expr>");
    r = expr(b, l + 1);
    exit_section_(b, l, m, INFIX_EXPR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_ITERATOR routine
  public static boolean IteratorDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IteratorDef")) return false;
    if (!nextTokenIs(b, T_ITERATOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_ITERATOR);
    p = r; // pin = 1
    r = r && routine(b, l + 1);
    exit_section_(b, l, m, ITERATOR_DEF, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_LET <<section VarDef>>
  public static boolean LetSect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LetSect")) return false;
    if (!nextTokenIs(b, T_LET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_LET);
    p = r; // pin = 1
    r = r && section(b, l + 1, VarDef_parser_);
    exit_section_(b, l, m, LET_SECT, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // NUMBER_LITERAL | CHARACTER_LITERAL | STRING_LITERAL
  public static boolean Literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<literal>");
    r = consumeToken(b, NUMBER_LITERAL);
    if (!r) r = consumeToken(b, CHARACTER_LITERAL);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, l, m, LITERAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_NIL
  public static boolean NilToken(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NilToken")) return false;
    if (!nextTokenIs(b, T_NIL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_NIL);
    exit_section_(b, m, NIL_TOKEN, r);
    return r;
  }

  /* ********************************************************** */
  // <<listOf (!<<eof>> complexOrSimpleStmt) (T_SEMICOLON (&INDNONE | &INDEQ) | &INDEQ)>>?
  static boolean NimFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NimFile")) return false;
    listOf(b, l + 1, NimFile_0_0_parser_, NimFile_0_1_parser_);
    return true;
  }

  // !<<eof>> complexOrSimpleStmt
  private static boolean NimFile_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NimFile_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NimFile_0_0_0(b, l + 1);
    r = r && complexOrSimpleStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>>
  private static boolean NimFile_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NimFile_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // T_SEMICOLON (&INDNONE | &INDEQ) | &INDEQ
  private static boolean NimFile_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NimFile_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NimFile_0_1_0(b, l + 1);
    if (!r) r = NimFile_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_SEMICOLON (&INDNONE | &INDEQ)
  private static boolean NimFile_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NimFile_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SEMICOLON);
    r = r && NimFile_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE | &INDEQ
  private static boolean NimFile_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NimFile_0_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NimFile_0_1_0_1_0(b, l + 1);
    if (!r) r = NimFile_0_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean NimFile_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NimFile_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &INDEQ
  private static boolean NimFile_0_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NimFile_0_1_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indEq(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &INDEQ
  private static boolean NimFile_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NimFile_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indEq(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_OBJECT (OPTIND Pragma)? (INDNONE T_OF TypeDesc)? (INDGT objectPart)?
  public static boolean ObjectDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectDef")) return false;
    if (!nextTokenIs(b, T_OBJECT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_OBJECT);
    p = r; // pin = 1
    r = r && report_error_(b, ObjectDef_1(b, l + 1));
    r = p && report_error_(b, ObjectDef_2(b, l + 1)) && r;
    r = p && ObjectDef_3(b, l + 1) && r;
    exit_section_(b, l, m, OBJECT_DEF, r, p, null);
    return r || p;
  }

  // (OPTIND Pragma)?
  private static boolean ObjectDef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectDef_1")) return false;
    ObjectDef_1_0(b, l + 1);
    return true;
  }

  // OPTIND Pragma
  private static boolean ObjectDef_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectDef_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && Pragma(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (INDNONE T_OF TypeDesc)?
  private static boolean ObjectDef_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectDef_2")) return false;
    ObjectDef_2_0(b, l + 1);
    return true;
  }

  // INDNONE T_OF TypeDesc
  private static boolean ObjectDef_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectDef_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indNone(b, l + 1);
    r = r && consumeToken(b, T_OF);
    r = r && TypeDesc(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (INDGT objectPart)?
  private static boolean ObjectDef_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectDef_3")) return false;
    ObjectDef_3_0(b, l + 1);
    return true;
  }

  // INDGT objectPart
  private static boolean ObjectDef_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectDef_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indGt(b, l + 1);
    r = r && objectPart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // &INDNONE T_LPAREN OPTIND <<listOf identColonEqualsWithBothOptionalWithPragma (T_COMMA | T_SEMICOLON)>>? T_RPAREN
  public static boolean ParamList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList")) return false;
    if (!nextTokenIs(b, T_LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = ParamList_0(b, l + 1);
    r = r && consumeToken(b, T_LPAREN);
    p = r; // pin = 2
    r = r && report_error_(b, indOpt(b, l + 1));
    r = p && report_error_(b, ParamList_3(b, l + 1)) && r;
    r = p && consumeToken(b, T_RPAREN) && r;
    exit_section_(b, l, m, PARAM_LIST, r, p, null);
    return r || p;
  }

  // &INDNONE
  private static boolean ParamList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // <<listOf identColonEqualsWithBothOptionalWithPragma (T_COMMA | T_SEMICOLON)>>?
  private static boolean ParamList_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList_3")) return false;
    listOf(b, l + 1, identColonEqualsWithBothOptionalWithPragma_parser_, ParamList_3_0_1_parser_);
    return true;
  }

  // T_COMMA | T_SEMICOLON
  private static boolean ParamList_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    if (!r) r = consumeToken(b, T_SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_LBRACE stmt T_RBRACE
  public static boolean Pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pattern")) return false;
    if (!nextTokenIs(b, T_LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, stmt(b, l + 1));
    r = p && consumeToken(b, T_RBRACE) && r;
    exit_section_(b, l, m, PATTERN, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_BRACEDOT <<enterPragma (OPTIND (exprColonEqExpr T_COMMA?)*)>> (T_DOTBRACE | T_RBRACE)
  public static boolean Pragma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pragma")) return false;
    if (!nextTokenIs(b, T_BRACEDOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_BRACEDOT);
    p = r; // pin = 1
    r = r && report_error_(b, enterPragma(b, l + 1, Pragma_1_0_parser_));
    r = p && Pragma_2(b, l + 1) && r;
    exit_section_(b, l, m, PRAGMA, r, p, null);
    return r || p;
  }

  // OPTIND (exprColonEqExpr T_COMMA?)*
  private static boolean Pragma_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pragma_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && Pragma_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (exprColonEqExpr T_COMMA?)*
  private static boolean Pragma_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pragma_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!Pragma_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Pragma_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // exprColonEqExpr T_COMMA?
  private static boolean Pragma_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pragma_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = exprColonEqExpr(b, l + 1);
    r = r && Pragma_1_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COMMA?
  private static boolean Pragma_1_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pragma_1_0_1_0_1")) return false;
    consumeToken(b, T_COMMA);
    return true;
  }

  // T_DOTBRACE | T_RBRACE
  private static boolean Pragma_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Pragma_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_DOTBRACE);
    if (!r) r = consumeToken(b, T_RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Pragma (&INDNONE T_COLON stmt)?
  public static boolean PragmaStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PragmaStmt")) return false;
    if (!nextTokenIs(b, T_BRACEDOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Pragma(b, l + 1);
    r = r && PragmaStmt_1(b, l + 1);
    exit_section_(b, m, PRAGMA_STMT, r);
    return r;
  }

  // (&INDNONE T_COLON stmt)?
  private static boolean PragmaStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PragmaStmt_1")) return false;
    PragmaStmt_1_0(b, l + 1);
    return true;
  }

  // &INDNONE T_COLON stmt
  private static boolean PragmaStmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PragmaStmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PragmaStmt_1_0_0(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean PragmaStmt_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PragmaStmt_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // anyOperator OPTIND primary
  public static boolean PrefixExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixExpr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<prefix expr>");
    r = anyOperator(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, indOpt(b, l + 1));
    r = p && primary(b, l + 1) && r;
    exit_section_(b, l, m, PREFIX_EXPR, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_PROC routine
  public static boolean ProcDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ProcDef")) return false;
    if (!nextTokenIs(b, T_PROC)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_PROC);
    p = r; // pin = 1
    r = r && routine(b, l + 1);
    exit_section_(b, l, m, PROC_DEF, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_RAISE (OPTIND &isExprStart expr)?
  public static boolean RaiseStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RaiseStmt")) return false;
    if (!nextTokenIs(b, T_RAISE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_RAISE);
    p = r; // pin = 1
    r = r && RaiseStmt_1(b, l + 1);
    exit_section_(b, l, m, RAISE_STMT, r, p, null);
    return r || p;
  }

  // (OPTIND &isExprStart expr)?
  private static boolean RaiseStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RaiseStmt_1")) return false;
    RaiseStmt_1_0(b, l + 1);
    return true;
  }

  // OPTIND &isExprStart expr
  private static boolean RaiseStmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RaiseStmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && RaiseStmt_1_0_1(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &isExprStart
  private static boolean RaiseStmt_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RaiseStmt_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = isExprStart(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_RETURN (OPTIND &isExprStart expr)?
  public static boolean ReturnStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStmt")) return false;
    if (!nextTokenIs(b, T_RETURN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_RETURN);
    p = r; // pin = 1
    r = r && ReturnStmt_1(b, l + 1);
    exit_section_(b, l, m, RETURN_STMT, r, p, null);
    return r || p;
  }

  // (OPTIND &isExprStart expr)?
  private static boolean ReturnStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStmt_1")) return false;
    ReturnStmt_1_0(b, l + 1);
    return true;
  }

  // OPTIND &isExprStart expr
  private static boolean ReturnStmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && ReturnStmt_1_0_1(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &isExprStart
  private static boolean ReturnStmt_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStmt_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = isExprStart(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // stmt
  public static boolean RoutineBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RoutineBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<routine body>");
    r = stmt(b, l + 1);
    exit_section_(b, l, m, ROUTINE_BODY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_LBRACE &OPTIND (T_COLON | <<listOf exprColonEqExpr (T_COMMA)>>? T_COMMA?) T_RBRACE
  public static boolean SetOrTableCtor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetOrTableCtor")) return false;
    if (!nextTokenIs(b, T_LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LBRACE);
    r = r && SetOrTableCtor_1(b, l + 1);
    r = r && SetOrTableCtor_2(b, l + 1);
    r = r && consumeToken(b, T_RBRACE);
    exit_section_(b, m, SET_OR_TABLE_CTOR, r);
    return r;
  }

  // &OPTIND
  private static boolean SetOrTableCtor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetOrTableCtor_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // T_COLON | <<listOf exprColonEqExpr (T_COMMA)>>? T_COMMA?
  private static boolean SetOrTableCtor_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetOrTableCtor_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    if (!r) r = SetOrTableCtor_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<listOf exprColonEqExpr (T_COMMA)>>? T_COMMA?
  private static boolean SetOrTableCtor_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetOrTableCtor_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SetOrTableCtor_2_1_0(b, l + 1);
    r = r && SetOrTableCtor_2_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<listOf exprColonEqExpr (T_COMMA)>>?
  private static boolean SetOrTableCtor_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetOrTableCtor_2_1_0")) return false;
    listOf(b, l + 1, exprColonEqExpr_parser_, SetOrTableCtor_2_1_0_0_1_parser_);
    return true;
  }

  // (T_COMMA)
  private static boolean SetOrTableCtor_2_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetOrTableCtor_2_1_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COMMA?
  private static boolean SetOrTableCtor_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetOrTableCtor_2_1_1")) return false;
    consumeToken(b, T_COMMA);
    return true;
  }

  /* ********************************************************** */
  // IDENT | T_ADDR | T_TYPE | ACCENT_QUOTED
  public static boolean Symbol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Symbol")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<symbol>");
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, T_ADDR);
    if (!r) r = consumeToken(b, T_TYPE);
    if (!r) r = consumeToken(b, ACCENT_QUOTED);
    exit_section_(b, l, m, SYMBOL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_TEMPLATE routine
  public static boolean TemplateDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TemplateDef")) return false;
    if (!nextTokenIs(b, T_TEMPLATE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_TEMPLATE);
    p = r; // pin = 1
    r = r && routine(b, l + 1);
    exit_section_(b, l, m, TEMPLATE_DEF, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_TRY T_COLON stmt (&(INDNONE | INDEQ) T_EXCEPT &OPTIND exprList T_COLON stmt)*
  //             (&(INDNONE | INDEQ) T_FINALLY &OPTIND exprList T_COLON stmt)?
  public static boolean TryStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt")) return false;
    if (!nextTokenIs(b, T_TRY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 1, T_TRY, T_COLON);
    p = r; // pin = 1
    r = r && report_error_(b, stmt(b, l + 1));
    r = p && report_error_(b, TryStmt_3(b, l + 1)) && r;
    r = p && TryStmt_4(b, l + 1) && r;
    exit_section_(b, l, m, TRY_STMT, r, p, null);
    return r || p;
  }

  // (&(INDNONE | INDEQ) T_EXCEPT &OPTIND exprList T_COLON stmt)*
  private static boolean TryStmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!TryStmt_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TryStmt_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // &(INDNONE | INDEQ) T_EXCEPT &OPTIND exprList T_COLON stmt
  private static boolean TryStmt_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TryStmt_3_0_0(b, l + 1);
    r = r && consumeToken(b, T_EXCEPT);
    r = r && TryStmt_3_0_2(b, l + 1);
    r = r && exprList(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(INDNONE | INDEQ)
  private static boolean TryStmt_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = TryStmt_3_0_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // INDNONE | INDEQ
  private static boolean TryStmt_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indNone(b, l + 1);
    if (!r) r = indEq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &OPTIND
  private static boolean TryStmt_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt_3_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (&(INDNONE | INDEQ) T_FINALLY &OPTIND exprList T_COLON stmt)?
  private static boolean TryStmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt_4")) return false;
    TryStmt_4_0(b, l + 1);
    return true;
  }

  // &(INDNONE | INDEQ) T_FINALLY &OPTIND exprList T_COLON stmt
  private static boolean TryStmt_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TryStmt_4_0_0(b, l + 1);
    r = r && consumeToken(b, T_FINALLY);
    r = r && TryStmt_4_0_2(b, l + 1);
    r = r && exprList(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(INDNONE | INDEQ)
  private static boolean TryStmt_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = TryStmt_4_0_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // INDNONE | INDEQ
  private static boolean TryStmt_4_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt_4_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indNone(b, l + 1);
    if (!r) r = indEq(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &OPTIND
  private static boolean TryStmt_4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryStmt_4_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identWithPragma (OPTIND GenericParamList)? (T_EQ OPTIND <<typeDefMode simpleExpr>>)?
  public static boolean TypeDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<type def>");
    r = identWithPragma(b, l + 1);
    r = r && TypeDef_1(b, l + 1);
    r = r && TypeDef_2(b, l + 1);
    exit_section_(b, l, m, TYPE_DEF, r, false, null);
    return r;
  }

  // (OPTIND GenericParamList)?
  private static boolean TypeDef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDef_1")) return false;
    TypeDef_1_0(b, l + 1);
    return true;
  }

  // OPTIND GenericParamList
  private static boolean TypeDef_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDef_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && GenericParamList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_EQ OPTIND <<typeDefMode simpleExpr>>)?
  private static boolean TypeDef_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDef_2")) return false;
    TypeDef_2_0(b, l + 1);
    return true;
  }

  // T_EQ OPTIND <<typeDefMode simpleExpr>>
  private static boolean TypeDef_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDef_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EQ);
    r = r && indOpt(b, l + 1);
    r = r && typeDefMode(b, l + 1, simpleExpr_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<typeDescMode simpleExpr>>
  public static boolean TypeDesc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDesc")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<type desc>");
    r = typeDescMode(b, l + 1, simpleExpr_parser_);
    exit_section_(b, l, m, TYPE_DESC, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_TYPE !T_LPAREN <<section TypeDef>>
  public static boolean TypeSect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSect")) return false;
    if (!nextTokenIs(b, T_TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_TYPE);
    p = r; // pin = 1
    r = r && TypeSect_1(b, l + 1);
    r = r && section(b, l + 1, TypeDef_parser_);
    exit_section_(b, l, m, TYPE_SECT, r, p, null);
    return r || p;
  }

  // !T_LPAREN
  private static boolean TypeSect_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSect_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !consumeToken(b, T_LPAREN);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identColonEqualsWithPragma
  public static boolean VarDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDef")) return false;
    if (!nextTokenIs(b, "<var def>", ACCENT_QUOTED, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<var def>");
    r = identColonEqualsWithPragma(b, l + 1);
    exit_section_(b, l, m, VAR_DEF, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_VAR <<section VarDef>>
  public static boolean VarSect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarSect")) return false;
    if (!nextTokenIs(b, T_VAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_VAR);
    p = r; // pin = 1
    r = r && section(b, l + 1, VarDef_parser_);
    exit_section_(b, l, m, VAR_SECT, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_WHEN condExpr
  public static boolean WhenExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhenExpr")) return false;
    if (!nextTokenIs(b, T_WHEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_WHEN);
    r = r && condExpr(b, l + 1);
    exit_section_(b, m, WHEN_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // T_WHEN &OPTIND condStmt
  public static boolean WhenStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhenStmt")) return false;
    if (!nextTokenIs(b, T_WHEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_WHEN);
    p = r; // pin = 1
    r = r && WhenStmt_1(b, l + 1);
    r = r && condStmt(b, l + 1);
    exit_section_(b, l, m, WHEN_STMT, r, p, null);
    return r || p;
  }

  // &OPTIND
  private static boolean WhenStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhenStmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_WHILE &OPTIND expr T_COLON stmt
  public static boolean WhileStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStmt")) return false;
    if (!nextTokenIs(b, T_WHILE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_WHILE);
    p = r; // pin = 1
    r = r && WhileStmt_1(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && stmt(b, l + 1);
    exit_section_(b, l, m, WHILE_STMT, r, p, null);
    return r || p;
  }

  // &OPTIND
  private static boolean WhileStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_YIELD (OPTIND &isExprStart expr)?
  public static boolean YieldStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YieldStmt")) return false;
    if (!nextTokenIs(b, T_YIELD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_YIELD);
    p = r; // pin = 1
    r = r && YieldStmt_1(b, l + 1);
    exit_section_(b, l, m, YIELD_STMT, r, p, null);
    return r || p;
  }

  // (OPTIND &isExprStart expr)?
  private static boolean YieldStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YieldStmt_1")) return false;
    YieldStmt_1_0(b, l + 1);
    return true;
  }

  // OPTIND &isExprStart expr
  private static boolean YieldStmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YieldStmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && YieldStmt_1_0_1(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &isExprStart
  private static boolean YieldStmt_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "YieldStmt_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = isExprStart(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPERATOR | T_DIV | T_MOD | T_SHL | T_SHR | T_IN | T_NOTIN | T_IS | T_ISNOT | T_NOT | T_OF | T_AS
  //                       | T_DOTDOT | T_AND | T_OR | T_XOR
  static boolean anyOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anyOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR);
    if (!r) r = consumeToken(b, T_DIV);
    if (!r) r = consumeToken(b, T_MOD);
    if (!r) r = consumeToken(b, T_SHL);
    if (!r) r = consumeToken(b, T_SHR);
    if (!r) r = consumeToken(b, T_IN);
    if (!r) r = consumeToken(b, T_NOTIN);
    if (!r) r = consumeToken(b, T_IS);
    if (!r) r = consumeToken(b, T_ISNOT);
    if (!r) r = consumeToken(b, T_NOT);
    if (!r) r = consumeToken(b, T_OF);
    if (!r) r = consumeToken(b, T_AS);
    if (!r) r = consumeToken(b, T_DOTDOT);
    if (!r) r = consumeToken(b, T_AND);
    if (!r) r = consumeToken(b, T_OR);
    if (!r) r = consumeToken(b, T_XOR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // doBlocks
  public static boolean callWithDoBlocks(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callWithDoBlocks")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<call with do blocks>");
    r = doBlocks(b, l + 1);
    exit_section_(b, l, m, CALL_EXPR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (&INDEQ T_OF &OPTIND exprList T_COLON stmt)* (&INDEQ T_ELIF &OPTIND expr T_COLON stmt)* (&INDEQ T_ELSE T_COLON stmt)?
  static boolean caseBranches(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caseBranches_0(b, l + 1);
    r = r && caseBranches_1(b, l + 1);
    r = r && caseBranches_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (&INDEQ T_OF &OPTIND exprList T_COLON stmt)*
  private static boolean caseBranches_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!caseBranches_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseBranches_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // &INDEQ T_OF &OPTIND exprList T_COLON stmt
  private static boolean caseBranches_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caseBranches_0_0_0(b, l + 1);
    r = r && consumeToken(b, T_OF);
    r = r && caseBranches_0_0_2(b, l + 1);
    r = r && exprList(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDEQ
  private static boolean caseBranches_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indEq(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &OPTIND
  private static boolean caseBranches_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_0_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (&INDEQ T_ELIF &OPTIND expr T_COLON stmt)*
  private static boolean caseBranches_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!caseBranches_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseBranches_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // &INDEQ T_ELIF &OPTIND expr T_COLON stmt
  private static boolean caseBranches_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caseBranches_1_0_0(b, l + 1);
    r = r && consumeToken(b, T_ELIF);
    r = r && caseBranches_1_0_2(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDEQ
  private static boolean caseBranches_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indEq(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &OPTIND
  private static boolean caseBranches_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (&INDEQ T_ELSE T_COLON stmt)?
  private static boolean caseBranches_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_2")) return false;
    caseBranches_2_0(b, l + 1);
    return true;
  }

  // &INDEQ T_ELSE T_COLON stmt
  private static boolean caseBranches_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caseBranches_2_0_0(b, l + 1);
    r = r && consumeTokens(b, 0, T_ELSE, T_COLON);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDEQ
  private static boolean caseBranches_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranches_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indEq(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_CASE expr T_COLON? (<<indented caseBranches>> | caseBranches)
  static boolean caseStmtOrExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseStmtOrExpr")) return false;
    if (!nextTokenIs(b, T_CASE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_CASE);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1));
    r = p && report_error_(b, caseStmtOrExpr_2(b, l + 1)) && r;
    r = p && caseStmtOrExpr_3(b, l + 1) && r;
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  // T_COLON?
  private static boolean caseStmtOrExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseStmtOrExpr_2")) return false;
    consumeToken(b, T_COLON);
    return true;
  }

  // <<indented caseBranches>> | caseBranches
  private static boolean caseStmtOrExpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseStmtOrExpr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indented(b, l + 1, caseBranches_parser_);
    if (!r) r = caseBranches(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IfStmt
  //   | WhileStmt
  //   | CaseStmt
  //   | TryStmt
  //   | ForStmt
  //   | BlockStmt
  //   | ProcDef
  //   | IteratorDef
  //   | TemplateDef
  //   | TypeSect
  //   | ConstSect
  //   | LetSect
  //   | WhenStmt
  //   | VarSect
  //   | simpleStmt
  static boolean complexOrSimpleStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexOrSimpleStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = IfStmt(b, l + 1);
    if (!r) r = WhileStmt(b, l + 1);
    if (!r) r = CaseStmt(b, l + 1);
    if (!r) r = TryStmt(b, l + 1);
    if (!r) r = ForStmt(b, l + 1);
    if (!r) r = BlockStmt(b, l + 1);
    if (!r) r = ProcDef(b, l + 1);
    if (!r) r = IteratorDef(b, l + 1);
    if (!r) r = TemplateDef(b, l + 1);
    if (!r) r = TypeSect(b, l + 1);
    if (!r) r = ConstSect(b, l + 1);
    if (!r) r = LetSect(b, l + 1);
    if (!r) r = WhenStmt(b, l + 1);
    if (!r) r = VarSect(b, l + 1);
    if (!r) r = simpleStmt(b, l + 1);
    exit_section_(b, l, m, null, r, false, complexOrSimpleStmtRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // !(INDEQ | INDLT | T_SEMICOLON | T_RPAREN)
  static boolean complexOrSimpleStmtRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexOrSimpleStmtRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !complexOrSimpleStmtRecover_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // INDEQ | INDLT | T_SEMICOLON | T_RPAREN
  private static boolean complexOrSimpleStmtRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexOrSimpleStmtRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indEq(b, l + 1);
    if (!r) r = indLt(b, l + 1);
    if (!r) r = consumeToken(b, T_SEMICOLON);
    if (!r) r = consumeToken(b, T_RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<listOf (expr T_COLON expr &OPTIND) (T_ELIF)>> T_ELSE T_COLON expr
  static boolean condExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listOf(b, l + 1, condExpr_0_0_parser_, condExpr_0_1_parser_);
    r = r && consumeTokens(b, 0, T_ELSE, T_COLON);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr T_COLON expr &OPTIND
  private static boolean condExpr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condExpr_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && expr(b, l + 1);
    r = r && condExpr_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &OPTIND
  private static boolean condExpr_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condExpr_0_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (T_ELIF)
  private static boolean condExpr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condExpr_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_ELIF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<listOf (expr T_COLON stmt) ((&INDNONE | &INDEQ) T_ELIF)>> ((&INDNONE | &INDEQ) T_ELSE T_COLON stmt)?
  static boolean condStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listOf(b, l + 1, condStmt_0_0_parser_, condStmt_0_1_parser_);
    r = r && condStmt_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr T_COLON stmt
  private static boolean condStmt_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (&INDNONE | &INDEQ) T_ELIF
  private static boolean condStmt_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = condStmt_0_1_0(b, l + 1);
    r = r && consumeToken(b, T_ELIF);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE | &INDEQ
  private static boolean condStmt_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = condStmt_0_1_0_0(b, l + 1);
    if (!r) r = condStmt_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean condStmt_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &INDEQ
  private static boolean condStmt_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt_0_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indEq(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // ((&INDNONE | &INDEQ) T_ELSE T_COLON stmt)?
  private static boolean condStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt_1")) return false;
    condStmt_1_0(b, l + 1);
    return true;
  }

  // (&INDNONE | &INDEQ) T_ELSE T_COLON stmt
  private static boolean condStmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = condStmt_1_0_0(b, l + 1);
    r = r && consumeTokens(b, 0, T_ELSE, T_COLON);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE | &INDEQ
  private static boolean condStmt_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = condStmt_1_0_0_0(b, l + 1);
    if (!r) r = condStmt_1_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean condStmt_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &INDEQ
  private static boolean condStmt_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condStmt_1_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indEq(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<listOf DoBlock INDEQ>>?
  static boolean doBlocks(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doBlocks")) return false;
    listOf(b, l + 1, DoBlock_parser_, INDEQ_parser_);
    return true;
  }

  /* ********************************************************** */
  // IfExpr | WhenExpr | CaseExpr | simpleExpr
  static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfExpr(b, l + 1);
    if (!r) r = WhenExpr(b, l + 1);
    if (!r) r = CaseExpr(b, l + 1);
    if (!r) r = parseSimpleExpr(b, l + 1, primary_parser_, 0);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr (T_COLON expr | T_EQ expr)?
  static boolean exprColonEqExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprColonEqExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && exprColonEqExpr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COLON expr | T_EQ expr)?
  private static boolean exprColonEqExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprColonEqExpr_1")) return false;
    exprColonEqExpr_1_0(b, l + 1);
    return true;
  }

  // T_COLON expr | T_EQ expr
  private static boolean exprColonEqExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprColonEqExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = exprColonEqExpr_1_0_0(b, l + 1);
    if (!r) r = exprColonEqExpr_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COLON expr
  private static boolean exprColonEqExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprColonEqExpr_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_EQ expr
  private static boolean exprColonEqExpr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprColonEqExpr_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EQ);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OPTIND <<listOf exprColonEqExpr (T_COMMA)>>?
  static boolean exprColonEqExprList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprColonEqExprList")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && exprColonEqExprList_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<listOf exprColonEqExpr (T_COMMA)>>?
  private static boolean exprColonEqExprList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprColonEqExprList_1")) return false;
    listOf(b, l + 1, exprColonEqExpr_parser_, exprColonEqExprList_1_0_1_parser_);
    return true;
  }

  // (T_COMMA)
  private static boolean exprColonEqExprList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprColonEqExprList_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<listOf expr (T_COMMA &OPTIND)>>
  static boolean exprList(PsiBuilder b, int l) {
    return listOf(b, l + 1, expr_parser_, exprList_0_1_parser_);
  }

  // T_COMMA &OPTIND
  private static boolean exprList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprList_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && exprList_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &OPTIND
  private static boolean exprList_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprList_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<listOf ((&IDENT | &ACCENT_QUOTED) Symbol) (T_COMMA OPTIND)>> (T_COLON OPTIND expr)? (T_EQ OPTIND expr)?
  static boolean genericParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericParam")) return false;
    if (!nextTokenIs(b, "", ACCENT_QUOTED, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listOf(b, l + 1, genericParam_0_0_parser_, genericParam_0_1_parser_);
    r = r && genericParam_1(b, l + 1);
    r = r && genericParam_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (&IDENT | &ACCENT_QUOTED) Symbol
  private static boolean genericParam_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericParam_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = genericParam_0_0_0(b, l + 1);
    r = r && Symbol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &IDENT | &ACCENT_QUOTED
  private static boolean genericParam_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericParam_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = genericParam_0_0_0_0(b, l + 1);
    if (!r) r = genericParam_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &IDENT
  private static boolean genericParam_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericParam_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, IDENT);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &ACCENT_QUOTED
  private static boolean genericParam_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericParam_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, ACCENT_QUOTED);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // T_COMMA OPTIND
  private static boolean genericParam_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericParam_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && indOpt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COLON OPTIND expr)?
  private static boolean genericParam_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericParam_1")) return false;
    genericParam_1_0(b, l + 1);
    return true;
  }

  // T_COLON OPTIND expr
  private static boolean genericParam_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericParam_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_EQ OPTIND expr)?
  private static boolean genericParam_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericParam_2")) return false;
    genericParam_2_0(b, l + 1);
    return true;
  }

  // T_EQ OPTIND expr
  private static boolean genericParam_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericParam_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EQ);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<listOf (&(IDENT | ACCENT_QUOTED) Symbol) (T_COMMA OPTIND)>> (T_COMMA OPTIND)?
  //     (T_COLON OPTIND TypeDesc (T_EQ OPTIND expr)? | T_EQ OPTIND expr)
  static boolean identColonEquals(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals")) return false;
    if (!nextTokenIs(b, "", ACCENT_QUOTED, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listOf(b, l + 1, identColonEquals_0_0_parser_, identColonEquals_0_1_parser_);
    r = r && identColonEquals_1(b, l + 1);
    r = r && identColonEquals_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(IDENT | ACCENT_QUOTED) Symbol
  private static boolean identColonEquals_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identColonEquals_0_0_0(b, l + 1);
    r = r && Symbol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(IDENT | ACCENT_QUOTED)
  private static boolean identColonEquals_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = identColonEquals_0_0_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // IDENT | ACCENT_QUOTED
  private static boolean identColonEquals_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, ACCENT_QUOTED);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COMMA OPTIND
  private static boolean identColonEquals_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && indOpt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COMMA OPTIND)?
  private static boolean identColonEquals_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_1")) return false;
    identColonEquals_1_0(b, l + 1);
    return true;
  }

  // T_COMMA OPTIND
  private static boolean identColonEquals_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && indOpt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COLON OPTIND TypeDesc (T_EQ OPTIND expr)? | T_EQ OPTIND expr
  private static boolean identColonEquals_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identColonEquals_2_0(b, l + 1);
    if (!r) r = identColonEquals_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COLON OPTIND TypeDesc (T_EQ OPTIND expr)?
  private static boolean identColonEquals_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && indOpt(b, l + 1);
    r = r && TypeDesc(b, l + 1);
    r = r && identColonEquals_2_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_EQ OPTIND expr)?
  private static boolean identColonEquals_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_2_0_3")) return false;
    identColonEquals_2_0_3_0(b, l + 1);
    return true;
  }

  // T_EQ OPTIND expr
  private static boolean identColonEquals_2_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_2_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EQ);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_EQ OPTIND expr
  private static boolean identColonEquals_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEquals_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EQ);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<listOf (&(IDENT | ACCENT_QUOTED) identWithPragma) (T_COMMA OPTIND)>> (T_COMMA OPTIND)?
  //     (T_COLON OPTIND TypeDesc)? (T_EQ OPTIND expr)?
  static boolean identColonEqualsWithBothOptionalWithPragma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma")) return false;
    if (!nextTokenIs(b, "", ACCENT_QUOTED, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listOf(b, l + 1, identColonEqualsWithBothOptionalWithPragma_0_0_parser_, identColonEqualsWithBothOptionalWithPragma_0_1_parser_);
    r = r && identColonEqualsWithBothOptionalWithPragma_1(b, l + 1);
    r = r && identColonEqualsWithBothOptionalWithPragma_2(b, l + 1);
    r = r && identColonEqualsWithBothOptionalWithPragma_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(IDENT | ACCENT_QUOTED) identWithPragma
  private static boolean identColonEqualsWithBothOptionalWithPragma_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identColonEqualsWithBothOptionalWithPragma_0_0_0(b, l + 1);
    r = r && identWithPragma(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(IDENT | ACCENT_QUOTED)
  private static boolean identColonEqualsWithBothOptionalWithPragma_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = identColonEqualsWithBothOptionalWithPragma_0_0_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // IDENT | ACCENT_QUOTED
  private static boolean identColonEqualsWithBothOptionalWithPragma_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, ACCENT_QUOTED);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COMMA OPTIND
  private static boolean identColonEqualsWithBothOptionalWithPragma_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && indOpt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COMMA OPTIND)?
  private static boolean identColonEqualsWithBothOptionalWithPragma_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma_1")) return false;
    identColonEqualsWithBothOptionalWithPragma_1_0(b, l + 1);
    return true;
  }

  // T_COMMA OPTIND
  private static boolean identColonEqualsWithBothOptionalWithPragma_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && indOpt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COLON OPTIND TypeDesc)?
  private static boolean identColonEqualsWithBothOptionalWithPragma_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma_2")) return false;
    identColonEqualsWithBothOptionalWithPragma_2_0(b, l + 1);
    return true;
  }

  // T_COLON OPTIND TypeDesc
  private static boolean identColonEqualsWithBothOptionalWithPragma_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && indOpt(b, l + 1);
    r = r && TypeDesc(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_EQ OPTIND expr)?
  private static boolean identColonEqualsWithBothOptionalWithPragma_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma_3")) return false;
    identColonEqualsWithBothOptionalWithPragma_3_0(b, l + 1);
    return true;
  }

  // T_EQ OPTIND expr
  private static boolean identColonEqualsWithBothOptionalWithPragma_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithBothOptionalWithPragma_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EQ);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<listOf (&(IDENT | ACCENT_QUOTED) identWithPragma) (T_COMMA OPTIND)>> (T_COMMA OPTIND)?
  //     (T_COLON OPTIND TypeDesc (T_EQ OPTIND expr)? | T_EQ OPTIND expr)
  static boolean identColonEqualsWithPragma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma")) return false;
    if (!nextTokenIs(b, "", ACCENT_QUOTED, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listOf(b, l + 1, identColonEqualsWithPragma_0_0_parser_, identColonEqualsWithPragma_0_1_parser_);
    r = r && identColonEqualsWithPragma_1(b, l + 1);
    r = r && identColonEqualsWithPragma_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(IDENT | ACCENT_QUOTED) identWithPragma
  private static boolean identColonEqualsWithPragma_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identColonEqualsWithPragma_0_0_0(b, l + 1);
    r = r && identWithPragma(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(IDENT | ACCENT_QUOTED)
  private static boolean identColonEqualsWithPragma_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = identColonEqualsWithPragma_0_0_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // IDENT | ACCENT_QUOTED
  private static boolean identColonEqualsWithPragma_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, ACCENT_QUOTED);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COMMA OPTIND
  private static boolean identColonEqualsWithPragma_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && indOpt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COMMA OPTIND)?
  private static boolean identColonEqualsWithPragma_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_1")) return false;
    identColonEqualsWithPragma_1_0(b, l + 1);
    return true;
  }

  // T_COMMA OPTIND
  private static boolean identColonEqualsWithPragma_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && indOpt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COLON OPTIND TypeDesc (T_EQ OPTIND expr)? | T_EQ OPTIND expr
  private static boolean identColonEqualsWithPragma_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identColonEqualsWithPragma_2_0(b, l + 1);
    if (!r) r = identColonEqualsWithPragma_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COLON OPTIND TypeDesc (T_EQ OPTIND expr)?
  private static boolean identColonEqualsWithPragma_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && indOpt(b, l + 1);
    r = r && TypeDesc(b, l + 1);
    r = r && identColonEqualsWithPragma_2_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_EQ OPTIND expr)?
  private static boolean identColonEqualsWithPragma_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_2_0_3")) return false;
    identColonEqualsWithPragma_2_0_3_0(b, l + 1);
    return true;
  }

  // T_EQ OPTIND expr
  private static boolean identColonEqualsWithPragma_2_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_2_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EQ);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_EQ OPTIND expr
  private static boolean identColonEqualsWithPragma_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identColonEqualsWithPragma_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EQ);
    r = r && indOpt(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (&IDENT | &T_TYPE | &T_ADDR) Identifier /* generalizedLit */
  //     | &ACCENT_QUOTED Identifier
  //     | Literal
  //     | NilToken
  //     | BracketCtor
  //     | CastExpr
  //     | <<inNormalMode>> GroupedExpr
  //     | SetOrTableCtor
  static boolean identOrLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identOrLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identOrLiteral_0(b, l + 1);
    if (!r) r = identOrLiteral_1(b, l + 1);
    if (!r) r = Literal(b, l + 1);
    if (!r) r = NilToken(b, l + 1);
    if (!r) r = BracketCtor(b, l + 1);
    if (!r) r = CastExpr(b, l + 1);
    if (!r) r = identOrLiteral_6(b, l + 1);
    if (!r) r = SetOrTableCtor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (&IDENT | &T_TYPE | &T_ADDR) Identifier
  private static boolean identOrLiteral_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identOrLiteral_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identOrLiteral_0_0(b, l + 1);
    r = r && Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &IDENT | &T_TYPE | &T_ADDR
  private static boolean identOrLiteral_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identOrLiteral_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identOrLiteral_0_0_0(b, l + 1);
    if (!r) r = identOrLiteral_0_0_1(b, l + 1);
    if (!r) r = identOrLiteral_0_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &IDENT
  private static boolean identOrLiteral_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identOrLiteral_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, IDENT);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &T_TYPE
  private static boolean identOrLiteral_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identOrLiteral_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, T_TYPE);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &T_ADDR
  private static boolean identOrLiteral_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identOrLiteral_0_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, T_ADDR);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &ACCENT_QUOTED Identifier
  private static boolean identOrLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identOrLiteral_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identOrLiteral_1_0(b, l + 1);
    r = r && Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &ACCENT_QUOTED
  private static boolean identOrLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identOrLiteral_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, ACCENT_QUOTED);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // <<inNormalMode>> GroupedExpr
  private static boolean identOrLiteral_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identOrLiteral_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inNormalMode(b, l + 1);
    r = r && GroupedExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Symbol OPERATOR?
  static boolean identVis(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identVis")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Symbol(b, l + 1);
    r = r && identVis_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPERATOR?
  private static boolean identVis_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identVis_1")) return false;
    consumeToken(b, OPERATOR);
    return true;
  }

  /* ********************************************************** */
  // identVis Pragma?
  static boolean identWithPragma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identWithPragma")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identVis(b, l + 1);
    r = r && identWithPragma_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Pragma?
  private static boolean identWithPragma_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identWithPragma_1")) return false;
    Pragma(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENT | ACCENT_QUOTED | OPERATOR | T_NOT | T_NIL | T_CAST | T_IF | T_PROC | T_ITERATOR | T_BIND
  //                       | T_ADDR | T_LPAREN | T_LBRACKET | T_RBRACE | Literal | T_VAR | T_REF | T_PTR | T_TUPLE | T_OBJECT
  //                       | T_TYPE | T_WHEN | T_CASE | T_OUT
  static boolean isExprStart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isExprStart")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, ACCENT_QUOTED);
    if (!r) r = consumeToken(b, OPERATOR);
    if (!r) r = consumeToken(b, T_NOT);
    if (!r) r = consumeToken(b, T_NIL);
    if (!r) r = consumeToken(b, T_CAST);
    if (!r) r = consumeToken(b, T_IF);
    if (!r) r = consumeToken(b, T_PROC);
    if (!r) r = consumeToken(b, T_ITERATOR);
    if (!r) r = consumeToken(b, T_BIND);
    if (!r) r = consumeToken(b, T_ADDR);
    if (!r) r = consumeToken(b, T_LPAREN);
    if (!r) r = consumeToken(b, T_LBRACKET);
    if (!r) r = consumeToken(b, T_RBRACE);
    if (!r) r = Literal(b, l + 1);
    if (!r) r = consumeToken(b, T_VAR);
    if (!r) r = consumeToken(b, T_REF);
    if (!r) r = consumeToken(b, T_PTR);
    if (!r) r = consumeToken(b, T_TUPLE);
    if (!r) r = consumeToken(b, T_OBJECT);
    if (!r) r = consumeToken(b, T_TYPE);
    if (!r) r = consumeToken(b, T_WHEN);
    if (!r) r = consumeToken(b, T_CASE);
    if (!r) r = consumeToken(b, T_OUT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<p1>> (<<p2>> <<p1>>)*
  static boolean listOf(PsiBuilder b, int l, final Parser _p1, final Parser _p2) {
    if (!recursion_guard_(b, l, "listOf")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _p1.parse(b, l);
    r = r && listOf_1(b, l + 1, _p2, _p1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<p2>> <<p1>>)*
  private static boolean listOf_1(PsiBuilder b, int l, final Parser _p2, final Parser _p1) {
    if (!recursion_guard_(b, l, "listOf_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!listOf_1_0(b, l + 1, _p2, _p1)) break;
      if (!empty_element_parsed_guard_(b, "listOf_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // <<p2>> <<p1>>
  private static boolean listOf_1_0(PsiBuilder b, int l, final Parser _p2, final Parser _p1) {
    if (!recursion_guard_(b, l, "listOf_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _p2.parse(b, l);
    r = r && _p1.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (&INDNONE T_COLON (!(T_OF | T_ELIF | T_ELSE | T_EXCEPT) stmt)?)?
  static boolean macroColon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroColon")) return false;
    macroColon_0(b, l + 1);
    return true;
  }

  // &INDNONE T_COLON (!(T_OF | T_ELIF | T_ELSE | T_EXCEPT) stmt)?
  private static boolean macroColon_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroColon_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = macroColon_0_0(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && macroColon_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean macroColon_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroColon_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (!(T_OF | T_ELIF | T_ELSE | T_EXCEPT) stmt)?
  private static boolean macroColon_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroColon_0_2")) return false;
    macroColon_0_2_0(b, l + 1);
    return true;
  }

  // !(T_OF | T_ELIF | T_ELSE | T_EXCEPT) stmt
  private static boolean macroColon_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroColon_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = macroColon_0_2_0_0(b, l + 1);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(T_OF | T_ELIF | T_ELSE | T_EXCEPT)
  private static boolean macroColon_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroColon_0_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !macroColon_0_2_0_0_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // T_OF | T_ELIF | T_ELSE | T_EXCEPT
  private static boolean macroColon_0_2_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macroColon_0_2_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_OF);
    if (!r) r = consumeToken(b, T_ELIF);
    if (!r) r = consumeToken(b, T_ELSE);
    if (!r) r = consumeToken(b, T_EXCEPT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<indented (INDEQ &(T_CASE | T_WHEN | IDENT | ACCENT_QUOTED | T_NIL | T_DISCARD) objectPart)*>>
  //                      | /*objectWhen | objectCase |*/ identColonEqualsWithPragma | NilToken
  static boolean objectPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectPart")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indented(b, l + 1, objectPart_0_0_parser_);
    if (!r) r = identColonEqualsWithPragma(b, l + 1);
    if (!r) r = NilToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (INDEQ &(T_CASE | T_WHEN | IDENT | ACCENT_QUOTED | T_NIL | T_DISCARD) objectPart)*
  private static boolean objectPart_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectPart_0_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!objectPart_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "objectPart_0_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // INDEQ &(T_CASE | T_WHEN | IDENT | ACCENT_QUOTED | T_NIL | T_DISCARD) objectPart
  private static boolean objectPart_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectPart_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indEq(b, l + 1);
    r = r && objectPart_0_0_0_1(b, l + 1);
    r = r && objectPart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(T_CASE | T_WHEN | IDENT | ACCENT_QUOTED | T_NIL | T_DISCARD)
  private static boolean objectPart_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectPart_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = objectPart_0_0_0_1_0(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // T_CASE | T_WHEN | IDENT | ACCENT_QUOTED | T_NIL | T_DISCARD
  private static boolean objectPart_0_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectPart_0_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_CASE);
    if (!r) r = consumeToken(b, T_WHEN);
    if (!r) r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, ACCENT_QUOTED);
    if (!r) r = consumeToken(b, T_NIL);
    if (!r) r = consumeToken(b, T_DISCARD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_DISCARD | T_INCLUDE | T_IF | T_WHILE | T_CASE | T_TRY | T_DEFER | T_FINALLY | T_EXCEPT | T_FOR
  //                   | T_BLOCK | T_CONST | T_LET | T_WHEN | T_VAR | T_MIXIN
  static boolean parKeyw(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parKeyw")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_DISCARD);
    if (!r) r = consumeToken(b, T_INCLUDE);
    if (!r) r = consumeToken(b, T_IF);
    if (!r) r = consumeToken(b, T_WHILE);
    if (!r) r = consumeToken(b, T_CASE);
    if (!r) r = consumeToken(b, T_TRY);
    if (!r) r = consumeToken(b, T_DEFER);
    if (!r) r = consumeToken(b, T_FINALLY);
    if (!r) r = consumeToken(b, T_EXCEPT);
    if (!r) r = consumeToken(b, T_FOR);
    if (!r) r = consumeToken(b, T_BLOCK);
    if (!r) r = consumeToken(b, T_CONST);
    if (!r) r = consumeToken(b, T_LET);
    if (!r) r = consumeToken(b, T_WHEN);
    if (!r) r = consumeToken(b, T_VAR);
    if (!r) r = consumeToken(b, T_MIXIN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ParamList? (&INDNONE <<arrow>> OPTIND TypeDesc)?
  static boolean paramListArrow(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramListArrow")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paramListArrow_0(b, l + 1);
    r = r && paramListArrow_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ParamList?
  private static boolean paramListArrow_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramListArrow_0")) return false;
    ParamList(b, l + 1);
    return true;
  }

  // (&INDNONE <<arrow>> OPTIND TypeDesc)?
  private static boolean paramListArrow_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramListArrow_1")) return false;
    paramListArrow_1_0(b, l + 1);
    return true;
  }

  // &INDNONE <<arrow>> OPTIND TypeDesc
  private static boolean paramListArrow_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramListArrow_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paramListArrow_1_0_0(b, l + 1);
    r = r && arrow(b, l + 1);
    r = r && indOpt(b, l + 1);
    r = r && TypeDesc(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean paramListArrow_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramListArrow_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ParamList? (&INDNONE T_COLON OPTIND TypeDesc)?
  static boolean paramListColon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramListColon")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paramListColon_0(b, l + 1);
    r = r && paramListColon_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ParamList?
  private static boolean paramListColon_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramListColon_0")) return false;
    ParamList(b, l + 1);
    return true;
  }

  // (&INDNONE T_COLON OPTIND TypeDesc)?
  private static boolean paramListColon_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramListColon_1")) return false;
    paramListColon_1_0(b, l + 1);
    return true;
  }

  // &INDNONE T_COLON OPTIND TypeDesc
  private static boolean paramListColon_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramListColon_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paramListColon_1_0_0(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && indOpt(b, l + 1);
    r = r && TypeDesc(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean paramListColon_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramListColon_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PrefixExpr
  //     | tuple
  //     | procExpr
  //     | <<inTypeDefMode>> EnumDef
  //     | <<inTypeDefMode>> ObjectDef
  //     | T_VAR OPTIND typeDescK
  //     | T_PTR OPTIND typeDescK
  //     | identOrLiteral primarySuffix*
  static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PrefixExpr(b, l + 1);
    if (!r) r = tuple(b, l + 1);
    if (!r) r = procExpr(b, l + 1);
    if (!r) r = primary_3(b, l + 1);
    if (!r) r = primary_4(b, l + 1);
    if (!r) r = primary_5(b, l + 1);
    if (!r) r = primary_6(b, l + 1);
    if (!r) r = primary_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<inTypeDefMode>> EnumDef
  private static boolean primary_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inTypeDefMode(b, l + 1);
    r = r && EnumDef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<inTypeDefMode>> ObjectDef
  private static boolean primary_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inTypeDefMode(b, l + 1);
    r = r && ObjectDef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_VAR OPTIND typeDescK
  private static boolean primary_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_VAR);
    r = r && indOpt(b, l + 1);
    r = r && typeDescK(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_PTR OPTIND typeDescK
  private static boolean primary_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_PTR);
    r = r && indOpt(b, l + 1);
    r = r && typeDescK(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // identOrLiteral primarySuffix*
  private static boolean primary_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identOrLiteral(b, l + 1);
    r = r && primary_7_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // primarySuffix*
  private static boolean primary_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_7_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!primarySuffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primary_7_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // INDNONE (CallExpr | &T_DO callWithDoBlocks | BracketExpr | CommandExpr) | DotExpr
  static boolean primarySuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primarySuffix")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primarySuffix_0(b, l + 1);
    if (!r) r = DotExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // INDNONE (CallExpr | &T_DO callWithDoBlocks | BracketExpr | CommandExpr)
  private static boolean primarySuffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primarySuffix_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indNone(b, l + 1);
    r = r && primarySuffix_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CallExpr | &T_DO callWithDoBlocks | BracketExpr | CommandExpr
  private static boolean primarySuffix_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primarySuffix_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CallExpr(b, l + 1);
    if (!r) r = primarySuffix_0_1_1(b, l + 1);
    if (!r) r = BracketExpr(b, l + 1);
    if (!r) r = CommandExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &T_DO callWithDoBlocks
  private static boolean primarySuffix_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primarySuffix_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primarySuffix_0_1_1_0(b, l + 1);
    r = r && callWithDoBlocks(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &T_DO
  private static boolean primarySuffix_0_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primarySuffix_0_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, T_DO);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (T_PROC | T_ITERATOR) (INDNONE paramListColon? Pragma?)? (<<inNormalMode>> T_EQ stmt)?
  static boolean procExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procExpr")) return false;
    if (!nextTokenIs(b, "", T_ITERATOR, T_PROC)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = procExpr_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, procExpr_1(b, l + 1));
    r = p && procExpr_2(b, l + 1) && r;
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  // T_PROC | T_ITERATOR
  private static boolean procExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_PROC);
    if (!r) r = consumeToken(b, T_ITERATOR);
    exit_section_(b, m, null, r);
    return r;
  }

  // (INDNONE paramListColon? Pragma?)?
  private static boolean procExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procExpr_1")) return false;
    procExpr_1_0(b, l + 1);
    return true;
  }

  // INDNONE paramListColon? Pragma?
  private static boolean procExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indNone(b, l + 1);
    r = r && procExpr_1_0_1(b, l + 1);
    r = r && procExpr_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // paramListColon?
  private static boolean procExpr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procExpr_1_0_1")) return false;
    paramListColon(b, l + 1);
    return true;
  }

  // Pragma?
  private static boolean procExpr_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procExpr_1_0_2")) return false;
    Pragma(b, l + 1);
    return true;
  }

  // (<<inNormalMode>> T_EQ stmt)?
  private static boolean procExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procExpr_2")) return false;
    procExpr_2_0(b, l + 1);
    return true;
  }

  // <<inNormalMode>> T_EQ stmt
  private static boolean procExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inNormalMode(b, l + 1);
    r = r && consumeToken(b, T_EQ);
    r = r && stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // &OPTIND identVis (OPTIND Pattern)? (OPTIND GenericParamList)? INDNONE paramListColon (OPTIND Pragma)? (OPTIND T_EQ RoutineBody)?
  static boolean routine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routine")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = routine_0(b, l + 1);
    r = r && identVis(b, l + 1);
    r = r && routine_2(b, l + 1);
    r = r && routine_3(b, l + 1);
    r = r && indNone(b, l + 1);
    r = r && paramListColon(b, l + 1);
    r = r && routine_6(b, l + 1);
    r = r && routine_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &OPTIND
  private static boolean routine_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routine_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indOpt(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (OPTIND Pattern)?
  private static boolean routine_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routine_2")) return false;
    routine_2_0(b, l + 1);
    return true;
  }

  // OPTIND Pattern
  private static boolean routine_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routine_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && Pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (OPTIND GenericParamList)?
  private static boolean routine_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routine_3")) return false;
    routine_3_0(b, l + 1);
    return true;
  }

  // OPTIND GenericParamList
  private static boolean routine_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routine_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && GenericParamList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (OPTIND Pragma)?
  private static boolean routine_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routine_6")) return false;
    routine_6_0(b, l + 1);
    return true;
  }

  // OPTIND Pragma
  private static boolean routine_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routine_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && Pragma(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (OPTIND T_EQ RoutineBody)?
  private static boolean routine_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routine_7")) return false;
    routine_7_0(b, l + 1);
    return true;
  }

  // OPTIND T_EQ RoutineBody
  private static boolean routine_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "routine_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indOpt(b, l + 1);
    r = r && consumeToken(b, T_EQ);
    r = r && RoutineBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // &INDNONE <<p>> | <<indented <<listOf <<p>> INDEQ>>>>
  static boolean section(PsiBuilder b, int l, final Parser _p) {
    if (!recursion_guard_(b, l, "section")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = section_0(b, l + 1, _p);
    if (!r) r = indented(b, l + 1, new Parser() {
      public boolean parse(PsiBuilder b, int l) {
        return listOf(b, l + 1, _p, INDEQ_parser_);
      }
    });
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE <<p>>
  private static boolean section_0(PsiBuilder b, int l, final Parser _p) {
    if (!recursion_guard_(b, l, "section_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = section_0_0(b, l + 1);
    r = r && _p.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean section_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "section_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<enterSemiStmtList <<listOf complexOrSimpleStmt (T_SEMICOLON OPTIND)>>>>
  static boolean semiStmtList(PsiBuilder b, int l) {
    return enterSemiStmtList(b, l + 1, semiStmtList_0_0_parser_);
  }

  // T_SEMICOLON OPTIND
  private static boolean semiStmtList_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semiStmtList_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SEMICOLON);
    r = r && indOpt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ReturnStmt
  //   | RaiseStmt
  //   | YieldStmt
  //   | DiscardStmt
  //   | BreakStmt
  //   | PragmaStmt
  //   | ImportStmt
  //   | (&isExprStart ExprStmt)?
  static boolean simpleStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleStmt")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ReturnStmt(b, l + 1);
    if (!r) r = RaiseStmt(b, l + 1);
    if (!r) r = YieldStmt(b, l + 1);
    if (!r) r = DiscardStmt(b, l + 1);
    if (!r) r = BreakStmt(b, l + 1);
    if (!r) r = PragmaStmt(b, l + 1);
    if (!r) r = ImportStmt(b, l + 1);
    if (!r) r = simpleStmt_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (&isExprStart ExprStmt)?
  private static boolean simpleStmt_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleStmt_7")) return false;
    simpleStmt_7_0(b, l + 1);
    return true;
  }

  // &isExprStart ExprStmt
  private static boolean simpleStmt_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleStmt_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simpleStmt_7_0_0(b, l + 1);
    r = r && ExprStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &isExprStart
  private static boolean simpleStmt_7_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleStmt_7_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = isExprStart(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<indented <<listOf complexOrSimpleStmt (T_SEMICOLON (&INDNONE | &INDEQ) | &INDEQ)>>>>
  //     | !<<inSemiStmtList>> <<listOf (&INDNONE simpleStmt) (T_SEMICOLON)>>
  //     | &<<inSemiStmtList>> simpleStmt
  static boolean stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indented(b, l + 1, stmt_0_0_parser_);
    if (!r) r = stmt_1(b, l + 1);
    if (!r) r = stmt_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_SEMICOLON (&INDNONE | &INDEQ) | &INDEQ
  private static boolean stmt_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stmt_0_0_1_0(b, l + 1);
    if (!r) r = stmt_0_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_SEMICOLON (&INDNONE | &INDEQ)
  private static boolean stmt_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SEMICOLON);
    r = r && stmt_0_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE | &INDEQ
  private static boolean stmt_0_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_0_0_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stmt_0_0_1_0_1_0(b, l + 1);
    if (!r) r = stmt_0_0_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean stmt_0_0_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_0_0_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &INDEQ
  private static boolean stmt_0_0_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_0_0_1_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indEq(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &INDEQ
  private static boolean stmt_0_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_0_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indEq(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // !<<inSemiStmtList>> <<listOf (&INDNONE simpleStmt) (T_SEMICOLON)>>
  private static boolean stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stmt_1_0(b, l + 1);
    r = r && listOf(b, l + 1, stmt_1_1_0_parser_, stmt_1_1_1_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<inSemiStmtList>>
  private static boolean stmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !inSemiStmtList(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &INDNONE simpleStmt
  private static boolean stmt_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stmt_1_1_0_0(b, l + 1);
    r = r && simpleStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &INDNONE
  private static boolean stmt_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_1_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = indNone(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // (T_SEMICOLON)
  private static boolean stmt_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_1_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<inSemiStmtList>> simpleStmt
  private static boolean stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stmt_2_0(b, l + 1);
    r = r && simpleStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<inSemiStmtList>>
  private static boolean stmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = inSemiStmtList(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_TUPLE (T_LBRACKET OPTIND <<listOf identColonEquals (T_COMMA | T_SEMICOLON)>> (T_COMMA | T_SEMICOLON)? T_RBRACKET)
  static boolean tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple")) return false;
    if (!nextTokenIs(b, T_TUPLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, T_TUPLE);
    p = r; // pin = 1
    r = r && tuple_1(b, l + 1);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  // T_LBRACKET OPTIND <<listOf identColonEquals (T_COMMA | T_SEMICOLON)>> (T_COMMA | T_SEMICOLON)? T_RBRACKET
  private static boolean tuple_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LBRACKET);
    r = r && indOpt(b, l + 1);
    r = r && listOf(b, l + 1, identColonEquals_parser_, tuple_1_2_1_parser_);
    r = r && tuple_1_3(b, l + 1);
    r = r && consumeToken(b, T_RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_COMMA | T_SEMICOLON
  private static boolean tuple_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_1_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    if (!r) r = consumeToken(b, T_SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_COMMA | T_SEMICOLON)?
  private static boolean tuple_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_1_3")) return false;
    tuple_1_3_0(b, l + 1);
    return true;
  }

  // T_COMMA | T_SEMICOLON
  private static boolean tuple_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    if (!r) r = consumeToken(b, T_SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !anyOperator &isExprStart primary
  static boolean typeDescK(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDescK")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeDescK_0(b, l + 1);
    r = r && typeDescK_1(b, l + 1);
    r = r && primary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !anyOperator
  private static boolean typeDescK_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDescK_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !anyOperator(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // &isExprStart
  private static boolean typeDescK_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDescK_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = isExprStart(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  final static Parser ConstDef_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return ConstDef(b, l + 1);
    }
  };
  final static Parser DoBlock_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return DoBlock(b, l + 1);
    }
  };
  final static Parser ExprStmt_1_0_1_1_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return ExprStmt_1_0_1_1_0_0(b, l + 1);
    }
  };
  final static Parser ForStmt_2_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return ForStmt_2_0(b, l + 1);
    }
  };
  final static Parser ForStmt_2_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return consumeToken(b, T_COMMA);
    }
  };
  final static Parser GenericParamList_2_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return GenericParamList_2_0_1(b, l + 1);
    }
  };
  final static Parser INDEQ_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return indEq(b, l + 1);
    }
  };
  final static Parser NimFile_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return NimFile_0_0(b, l + 1);
    }
  };
  final static Parser NimFile_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return NimFile_0_1(b, l + 1);
    }
  };
  final static Parser ParamList_3_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return ParamList_3_0_1(b, l + 1);
    }
  };
  final static Parser Pragma_1_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return Pragma_1_0(b, l + 1);
    }
  };
  final static Parser SetOrTableCtor_2_1_0_0_1_parser_ = ForStmt_2_1_parser_;
  final static Parser TypeDef_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return TypeDef(b, l + 1);
    }
  };
  final static Parser VarDef_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return VarDef(b, l + 1);
    }
  };
  final static Parser caseBranches_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return caseBranches(b, l + 1);
    }
  };
  final static Parser complexOrSimpleStmtRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return complexOrSimpleStmtRecover(b, l + 1);
    }
  };
  final static Parser complexOrSimpleStmt_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return complexOrSimpleStmt(b, l + 1);
    }
  };
  final static Parser condExpr_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return condExpr_0_0(b, l + 1);
    }
  };
  final static Parser condExpr_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return consumeToken(b, T_ELIF);
    }
  };
  final static Parser condStmt_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return condStmt_0_0(b, l + 1);
    }
  };
  final static Parser condStmt_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return condStmt_0_1(b, l + 1);
    }
  };
  final static Parser exprColonEqExprList_1_0_1_parser_ = ForStmt_2_1_parser_;
  final static Parser exprColonEqExpr_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return exprColonEqExpr(b, l + 1);
    }
  };
  final static Parser exprList_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return exprList_0_1(b, l + 1);
    }
  };
  final static Parser expr_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return expr(b, l + 1);
    }
  };
  final static Parser genericParam_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return genericParam_0_0(b, l + 1);
    }
  };
  final static Parser genericParam_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return genericParam_0_1(b, l + 1);
    }
  };
  final static Parser genericParam_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return genericParam(b, l + 1);
    }
  };
  final static Parser identColonEqualsWithBothOptionalWithPragma_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return identColonEqualsWithBothOptionalWithPragma_0_0(b, l + 1);
    }
  };
  final static Parser identColonEqualsWithBothOptionalWithPragma_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return identColonEqualsWithBothOptionalWithPragma_0_1(b, l + 1);
    }
  };
  final static Parser identColonEqualsWithBothOptionalWithPragma_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return identColonEqualsWithBothOptionalWithPragma(b, l + 1);
    }
  };
  final static Parser identColonEqualsWithPragma_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return identColonEqualsWithPragma_0_0(b, l + 1);
    }
  };
  final static Parser identColonEqualsWithPragma_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return identColonEqualsWithPragma_0_1(b, l + 1);
    }
  };
  final static Parser identColonEquals_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return identColonEquals_0_0(b, l + 1);
    }
  };
  final static Parser identColonEquals_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return identColonEquals_0_1(b, l + 1);
    }
  };
  final static Parser identColonEquals_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return identColonEquals(b, l + 1);
    }
  };
  final static Parser objectPart_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return objectPart_0_0(b, l + 1);
    }
  };
  final static Parser primary_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return primary(b, l + 1);
    }
  };
  final static Parser semiStmtList_0_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return semiStmtList_0_0_1(b, l + 1);
    }
  };
  final static Parser semiStmtList_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return listOf(b, l + 1, complexOrSimpleStmt_parser_, semiStmtList_0_0_1_parser_);
    }
  };
  final static Parser simpleExpr_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return parseSimpleExpr(b, l + 1, primary_parser_, 0);
    }
  };
  final static Parser stmt_0_0_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return stmt_0_0_1(b, l + 1);
    }
  };
  final static Parser stmt_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return listOf(b, l + 1, complexOrSimpleStmt_parser_, stmt_0_0_1_parser_);
    }
  };
  final static Parser stmt_1_1_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return stmt_1_1_0(b, l + 1);
    }
  };
  final static Parser stmt_1_1_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return consumeToken(b, T_SEMICOLON);
    }
  };
  final static Parser tuple_1_2_1_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return tuple_1_2_1(b, l + 1);
    }
  };
}
