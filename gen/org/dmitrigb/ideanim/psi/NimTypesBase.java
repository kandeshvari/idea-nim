// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.impl.*;

public interface NimTypesBase {

  IElementType ASSIGNMENT_EXPR = new NimElementType("ASSIGNMENT_EXPR");
  IElementType BLOCK = new NimElementType("BLOCK");
  IElementType BLOCK_STMT = new NimElementType("BLOCK_STMT");
  IElementType BRACKET_CTOR = new NimElementType("BRACKET_CTOR");
  IElementType BRACKET_EXPR = new NimElementType("BRACKET_EXPR");
  IElementType BREAK_STMT = new NimElementType("BREAK_STMT");
  IElementType CALL_EXPR = new NimElementType("CALL_EXPR");
  IElementType CASE_EXPR = new NimElementType("CASE_EXPR");
  IElementType CASE_STMT = new NimElementType("CASE_STMT");
  IElementType CAST_EXPR = new NimElementType("CAST_EXPR");
  IElementType COMMAND_EXPR = new NimElementType("COMMAND_EXPR");
  IElementType CONST_DEF = new NimElementType("CONST_DEF");
  IElementType CONST_SECT = new NimElementType("CONST_SECT");
  IElementType DISCARD_STMT = new NimElementType("DISCARD_STMT");
  IElementType DOT_EXPR = new NimElementType("DOT_EXPR");
  IElementType DO_BLOCK = new NimElementType("DO_BLOCK");
  IElementType ENUM_DEF = new NimElementType("ENUM_DEF");
  IElementType EXPRESSION = new NimElementType("EXPRESSION");
  IElementType EXPR_STMT = new NimElementType("EXPR_STMT");
  IElementType FOR_STMT = new NimElementType("FOR_STMT");
  IElementType GENERIC_PARAMETERS = new NimElementType("GENERIC_PARAMETERS");
  IElementType GROUPED_EXPR = new NimElementType("GROUPED_EXPR");
  IElementType IDENTIFIER = new NimElementType("IDENTIFIER");
  IElementType IDENTIFIER_DEF = new NimElementType("IDENTIFIER_DEF");
  IElementType IDENTIFIER_DEFS = new NimElementType("IDENTIFIER_DEFS");
  IElementType IDENTIFIER_EXPR = new NimElementType("IDENTIFIER_EXPR");
  IElementType IDENT_PRAGMA_PAIR = new NimElementType("IDENT_PRAGMA_PAIR");
  IElementType IF_EXPR = new NimElementType("IF_EXPR");
  IElementType IF_STMT = new NimElementType("IF_STMT");
  IElementType IMPORT_STMT = new NimElementType("IMPORT_STMT");
  IElementType INFIX_EXPR = new NimElementType("INFIX_EXPR");
  IElementType ITERATOR_DEF = new NimElementType("ITERATOR_DEF");
  IElementType LET_SECT = new NimElementType("LET_SECT");
  IElementType LITERAL = new NimElementType("LITERAL");
  IElementType NIL_TOKEN = new NimElementType("NIL_TOKEN");
  IElementType OBJECT_DEF = new NimElementType("OBJECT_DEF");
  IElementType PATTERN = new NimElementType("PATTERN");
  IElementType PRAGMA = new NimElementType("PRAGMA");
  IElementType PRAGMA_STMT = new NimElementType("PRAGMA_STMT");
  IElementType PREFIX_EXPR = new NimElementType("PREFIX_EXPR");
  IElementType PROC_DEF = new NimElementType("PROC_DEF");
  IElementType RAISE_STMT = new NimElementType("RAISE_STMT");
  IElementType RETURN_STMT = new NimElementType("RETURN_STMT");
  IElementType ROUTINE_DEF = new NimElementType("ROUTINE_DEF");
  IElementType SET_OR_TABLE_CTOR = new NimElementType("SET_OR_TABLE_CTOR");
  IElementType STATEMENT = new NimElementType("STATEMENT");
  IElementType STATIC_STMT = new NimElementType("STATIC_STMT");
  IElementType TEMPLATE_DEF = new NimElementType("TEMPLATE_DEF");
  IElementType TRY_STMT = new NimElementType("TRY_STMT");
  IElementType TYPE_DEF = new NimElementType("TYPE_DEF");
  IElementType TYPE_DESC = new NimElementType("TYPE_DESC");
  IElementType TYPE_SECT = new NimElementType("TYPE_SECT");
  IElementType VAR_DEF = new NimElementType("VAR_DEF");
  IElementType VAR_SECT = new NimElementType("VAR_SECT");
  IElementType WHEN_EXPR = new NimElementType("WHEN_EXPR");
  IElementType WHEN_STMT = new NimElementType("WHEN_STMT");
  IElementType WHILE_STMT = new NimElementType("WHILE_STMT");
  IElementType YIELD_STMT = new NimElementType("YIELD_STMT");

  IElementType ACCENT_QUOTED = new NimTokenType("ACCENT_QUOTED");
  IElementType CHARACTER_LITERAL = new NimTokenType("CHARACTER_LITERAL");
  IElementType IDENT = new NimTokenType("IDENT");
  IElementType NUMBER_LITERAL = new NimTokenType("NUMBER_LITERAL");
  IElementType OPERATOR = new NimTokenType("OPERATOR");
  IElementType STRING_LITERAL = new NimTokenType("STRING_LITERAL");
  IElementType T_ADDR = new NimTokenType("T_ADDR");
  IElementType T_AND = new NimTokenType("T_AND");
  IElementType T_AS = new NimTokenType("T_AS");
  IElementType T_BIND = new NimTokenType("T_BIND");
  IElementType T_BLOCK = new NimTokenType("T_BLOCK");
  IElementType T_BRACEDOT = new NimTokenType("T_BRACEDOT");
  IElementType T_BREAK = new NimTokenType("T_BREAK");
  IElementType T_CASE = new NimTokenType("T_CASE");
  IElementType T_CAST = new NimTokenType("T_CAST");
  IElementType T_COLON = new NimTokenType("T_COLON");
  IElementType T_COMMA = new NimTokenType("T_COMMA");
  IElementType T_CONST = new NimTokenType("T_CONST");
  IElementType T_DEFER = new NimTokenType("T_DEFER");
  IElementType T_DISCARD = new NimTokenType("T_DISCARD");
  IElementType T_DISTINCT = new NimTokenType("T_DISTINCT");
  IElementType T_DIV = new NimTokenType("T_DIV");
  IElementType T_DO = new NimTokenType("T_DO");
  IElementType T_DOT = new NimTokenType("T_DOT");
  IElementType T_DOTBRACE = new NimTokenType("T_DOTBRACE");
  IElementType T_DOTDOT = new NimTokenType("T_DOTDOT");
  IElementType T_ELIF = new NimTokenType("T_ELIF");
  IElementType T_ELSE = new NimTokenType("T_ELSE");
  IElementType T_ENUM = new NimTokenType("T_ENUM");
  IElementType T_EQ = new NimTokenType("T_EQ");
  IElementType T_EXCEPT = new NimTokenType("T_EXCEPT");
  IElementType T_FINALLY = new NimTokenType("T_FINALLY");
  IElementType T_FOR = new NimTokenType("T_FOR");
  IElementType T_IF = new NimTokenType("T_IF");
  IElementType T_IMPORT = new NimTokenType("T_IMPORT");
  IElementType T_IN = new NimTokenType("T_IN");
  IElementType T_INCLUDE = new NimTokenType("T_INCLUDE");
  IElementType T_IS = new NimTokenType("T_IS");
  IElementType T_ISNOT = new NimTokenType("T_ISNOT");
  IElementType T_ITERATOR = new NimTokenType("T_ITERATOR");
  IElementType T_LBRACE = new NimTokenType("T_LBRACE");
  IElementType T_LBRACKET = new NimTokenType("T_LBRACKET");
  IElementType T_LET = new NimTokenType("T_LET");
  IElementType T_LPAREN = new NimTokenType("T_LPAREN");
  IElementType T_MIXIN = new NimTokenType("T_MIXIN");
  IElementType T_MOD = new NimTokenType("T_MOD");
  IElementType T_NIL = new NimTokenType("T_NIL");
  IElementType T_NOT = new NimTokenType("T_NOT");
  IElementType T_NOTIN = new NimTokenType("T_NOTIN");
  IElementType T_OBJECT = new NimTokenType("T_OBJECT");
  IElementType T_OF = new NimTokenType("T_OF");
  IElementType T_OR = new NimTokenType("T_OR");
  IElementType T_OUT = new NimTokenType("T_OUT");
  IElementType T_PROC = new NimTokenType("T_PROC");
  IElementType T_PTR = new NimTokenType("T_PTR");
  IElementType T_RAISE = new NimTokenType("T_RAISE");
  IElementType T_RBRACE = new NimTokenType("T_RBRACE");
  IElementType T_RBRACKET = new NimTokenType("T_RBRACKET");
  IElementType T_REF = new NimTokenType("T_REF");
  IElementType T_RETURN = new NimTokenType("T_RETURN");
  IElementType T_RPAREN = new NimTokenType("T_RPAREN");
  IElementType T_SEMICOLON = new NimTokenType("T_SEMICOLON");
  IElementType T_SHL = new NimTokenType("T_SHL");
  IElementType T_SHR = new NimTokenType("T_SHR");
  IElementType T_STATIC = new NimTokenType("T_STATIC");
  IElementType T_TEMPLATE = new NimTokenType("T_TEMPLATE");
  IElementType T_TRY = new NimTokenType("T_TRY");
  IElementType T_TUPLE = new NimTokenType("T_TUPLE");
  IElementType T_TYPE = new NimTokenType("T_TYPE");
  IElementType T_VAR = new NimTokenType("T_VAR");
  IElementType T_WHEN = new NimTokenType("T_WHEN");
  IElementType T_WHILE = new NimTokenType("T_WHILE");
  IElementType T_XOR = new NimTokenType("T_XOR");
  IElementType T_YIELD = new NimTokenType("T_YIELD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ASSIGNMENT_EXPR) {
        return new AssignmentExprImpl(node);
      }
      else if (type == BLOCK) {
        return new BlockImpl(node);
      }
      else if (type == BLOCK_STMT) {
        return new BlockStmtImpl(node);
      }
      else if (type == BRACKET_CTOR) {
        return new BracketCtorImpl(node);
      }
      else if (type == BRACKET_EXPR) {
        return new BracketExprImpl(node);
      }
      else if (type == BREAK_STMT) {
        return new BreakStmtImpl(node);
      }
      else if (type == CALL_EXPR) {
        return new CallExprImpl(node);
      }
      else if (type == CASE_EXPR) {
        return new CaseExprImpl(node);
      }
      else if (type == CASE_STMT) {
        return new CaseStmtImpl(node);
      }
      else if (type == CAST_EXPR) {
        return new CastExprImpl(node);
      }
      else if (type == COMMAND_EXPR) {
        return new CommandExprImpl(node);
      }
      else if (type == CONST_DEF) {
        return new ConstDefImpl(node);
      }
      else if (type == CONST_SECT) {
        return new ConstSectImpl(node);
      }
      else if (type == DISCARD_STMT) {
        return new DiscardStmtImpl(node);
      }
      else if (type == DOT_EXPR) {
        return new DotExprImpl(node);
      }
      else if (type == DO_BLOCK) {
        return new DoBlockImpl(node);
      }
      else if (type == ENUM_DEF) {
        return new EnumDefImpl(node);
      }
      else if (type == EXPRESSION) {
        return new ExpressionImpl(node);
      }
      else if (type == EXPR_STMT) {
        return new ExprStmtImpl(node);
      }
      else if (type == FOR_STMT) {
        return new ForStmtImpl(node);
      }
      else if (type == GENERIC_PARAMETERS) {
        return new GenericParametersImpl(node);
      }
      else if (type == GROUPED_EXPR) {
        return new GroupedExprImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new IdentifierImpl(node);
      }
      else if (type == IDENTIFIER_DEF) {
        return new IdentifierDefImpl(node);
      }
      else if (type == IDENTIFIER_DEFS) {
        return new IdentifierDefsImpl(node);
      }
      else if (type == IDENTIFIER_EXPR) {
        return new IdentifierExprImpl(node);
      }
      else if (type == IDENT_PRAGMA_PAIR) {
        return new IdentPragmaPairImpl(node);
      }
      else if (type == IF_EXPR) {
        return new IfExprImpl(node);
      }
      else if (type == IF_STMT) {
        return new IfStmtImpl(node);
      }
      else if (type == IMPORT_STMT) {
        return new ImportStmtImpl(node);
      }
      else if (type == INFIX_EXPR) {
        return new InfixExprImpl(node);
      }
      else if (type == ITERATOR_DEF) {
        return new IteratorDefImpl(node);
      }
      else if (type == LET_SECT) {
        return new LetSectImpl(node);
      }
      else if (type == LITERAL) {
        return new LiteralImpl(node);
      }
      else if (type == NIL_TOKEN) {
        return new NilTokenImpl(node);
      }
      else if (type == OBJECT_DEF) {
        return new ObjectDefImpl(node);
      }
      else if (type == PATTERN) {
        return new PatternImpl(node);
      }
      else if (type == PRAGMA) {
        return new PragmaImpl(node);
      }
      else if (type == PRAGMA_STMT) {
        return new PragmaStmtImpl(node);
      }
      else if (type == PREFIX_EXPR) {
        return new PrefixExprImpl(node);
      }
      else if (type == PROC_DEF) {
        return new ProcDefImpl(node);
      }
      else if (type == RAISE_STMT) {
        return new RaiseStmtImpl(node);
      }
      else if (type == RETURN_STMT) {
        return new ReturnStmtImpl(node);
      }
      else if (type == ROUTINE_DEF) {
        return new RoutineDefImpl(node);
      }
      else if (type == SET_OR_TABLE_CTOR) {
        return new SetOrTableCtorImpl(node);
      }
      else if (type == STATEMENT) {
        return new StatementImpl(node);
      }
      else if (type == STATIC_STMT) {
        return new StaticStmtImpl(node);
      }
      else if (type == TEMPLATE_DEF) {
        return new TemplateDefImpl(node);
      }
      else if (type == TRY_STMT) {
        return new TryStmtImpl(node);
      }
      else if (type == TYPE_DEF) {
        return new TypeDefImpl(node);
      }
      else if (type == TYPE_DESC) {
        return new TypeDescImpl(node);
      }
      else if (type == TYPE_SECT) {
        return new TypeSectImpl(node);
      }
      else if (type == VAR_DEF) {
        return new VarDefImpl(node);
      }
      else if (type == VAR_SECT) {
        return new VarSectImpl(node);
      }
      else if (type == WHEN_EXPR) {
        return new WhenExprImpl(node);
      }
      else if (type == WHEN_STMT) {
        return new WhenStmtImpl(node);
      }
      else if (type == WHILE_STMT) {
        return new WhileStmtImpl(node);
      }
      else if (type == YIELD_STMT) {
        return new YieldStmtImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
