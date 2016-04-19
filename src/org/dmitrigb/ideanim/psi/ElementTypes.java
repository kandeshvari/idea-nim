package org.dmitrigb.ideanim.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.dmitrigb.ideanim.psi.stubs.TypeDefStubElementType;

public interface ElementTypes {
  IElementType IDENT = new NimTokenType("IDENT");
  IElementType ACCENT_QUOTED = new NimTokenType("ACCENT_QUOTED");
  IElementType INT_LITERAL = new NimTokenType("INT_LITERAL");
  IElementType INT8_LITERAL = new NimTokenType("INT8_LITERAL");
  IElementType INT16_LITERAL = new NimTokenType("INT16_LITERAL");
  IElementType INT32_LITERAL = new NimTokenType("INT32_LITERAL");
  IElementType INT64_LITERAL = new NimTokenType("INT64_LITERAL");
  IElementType UINT_LITERAL = new NimTokenType("UINT_LITERAL");
  IElementType UINT8_LITERAL = new NimTokenType("UINT8_LITERAL");
  IElementType UINT16_LITERAL = new NimTokenType("UINT16_LITERAL");
  IElementType UINT32_LITERAL = new NimTokenType("UINT32_LITERAL");
  IElementType UINT64_LITERAL = new NimTokenType("UINT64_LITERAL");
  IElementType FLOAT_LITERAL = new NimTokenType("FLOAT_LITERAL");
  IElementType FLOAT32_LITERAL = new NimTokenType("FLOAT32_LITERAL");
  IElementType FLOAT64_LITERAL = new NimTokenType("FLOAT64_LITERAL");
  IElementType CHARACTER_LITERAL = new NimTokenType("CHARACTER_LITERAL");
  IElementType TRIPLESTR_LITERAL = new NimTokenType("TRIPLESTR_LITERAL");
  IElementType STRING_LITERAL = new NimTokenType("STRING_LITERAL");
  IElementType BLOCK_COMMENT = new NimTokenType("BLOCK_COMMENT");
  IElementType LINE_COMMENT = new NimTokenType("LINE_COMMENT");
  IElementType OPERATOR = new NimTokenType("OPERATOR");

  IElementType T_ADDR = new NimTokenType("T_ADDR");
  IElementType T_AND = new NimTokenType("T_AND");
  IElementType T_AS = new NimTokenType("T_AS");
  IElementType T_ASM = new NimTokenType("T_ASM");
  IElementType T_ATOMIC = new NimTokenType("T_ATOMIC");
  IElementType T_BIND = new NimTokenType("T_BIND");
  IElementType T_BLOCK = new NimTokenType("T_BLOCK");
  IElementType T_BRACEDOT = new NimTokenType("T_BRACEDOT");
  IElementType T_BREAK = new NimTokenType("T_BREAK");
  IElementType T_CASE = new NimTokenType("T_CASE");
  IElementType T_CAST = new NimTokenType("T_CAST");
  IElementType T_COLON = new NimTokenType("T_COLON");
  IElementType T_COMMA = new NimTokenType("T_COMMA");
  IElementType T_CONCEPT = new NimTokenType("T_CONCEPT");
  IElementType T_CONST = new NimTokenType("T_CONST");
  IElementType T_CONTINUE = new NimTokenType("T_CONTINUE");
  IElementType T_CONVERTER = new NimTokenType("T_CONVERTER");
  IElementType T_DBLCOLON = new NimTokenType("T_DBLCOLON");
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
  IElementType T_END = new NimTokenType("T_END");
  IElementType T_ENUM = new NimTokenType("T_ENUM");
  IElementType T_EQ = new NimTokenType("T_EQ");
  IElementType T_EXCEPT = new NimTokenType("T_EXCEPT");
  IElementType T_EXPORT = new NimTokenType("T_EXPORT");
  IElementType T_FINALLY = new NimTokenType("T_FINALLY");
  IElementType T_FOR = new NimTokenType("T_FOR");
  IElementType T_FROM = new NimTokenType("T_FROM");
  IElementType T_FUNC = new NimTokenType("T_FUNC");
  IElementType T_GENERIC = new NimTokenType("T_GENERIC");
  IElementType T_IF = new NimTokenType("T_IF");
  IElementType T_IMPORT = new NimTokenType("T_IMPORT");
  IElementType T_IN = new NimTokenType("T_IN");
  IElementType T_INCLUDE = new NimTokenType("T_INCLUDE");
  IElementType T_INTERFACE = new NimTokenType("T_INTERFACE");
  IElementType T_IS = new NimTokenType("T_IS");
  IElementType T_ISNOT = new NimTokenType("T_ISNOT");
  IElementType T_ITERATOR = new NimTokenType("T_ITERATOR");
  IElementType T_LBRACE = new NimTokenType("T_LBRACE");
  IElementType T_LBRACKET = new NimTokenType("T_LBRACKET");
  IElementType T_LET = new NimTokenType("T_LET");
  IElementType T_LPAREN = new NimTokenType("T_LPAREN");
  IElementType T_MACRO = new NimTokenType("T_MACRO");
  IElementType T_METHOD = new NimTokenType("T_METHOD");
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
  IElementType T_USING = new NimTokenType("T_USING");
  IElementType T_VAR = new NimTokenType("T_VAR");
  IElementType T_WHEN = new NimTokenType("T_WHEN");
  IElementType T_WHILE = new NimTokenType("T_WHILE");
  IElementType T_WITH = new NimTokenType("T_WITH");
  IElementType T_WITHOUT = new NimTokenType("T_WITHOUT");
  IElementType T_XOR = new NimTokenType("T_XOR");
  IElementType T_YIELD = new NimTokenType("T_YIELD");

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
  IElementType CONTINUE_STMT = new NimElementType("CONTINUE_STMT");
  IElementType CTOR_ARG = new NimElementType("CTOR_ARG");
  IElementType DISCARD_STMT = new NimElementType("DISCARD_STMT");
  IElementType DISTINCT_TYPE_CLASS = new NimElementType("DISTINCT_TYPE_CLASS");
  IElementType DISTINCT_TYPE_EXPR = new NimElementType("DISTINCT_TYPE_EXPR");
  IElementType DOT_EXPR = new NimElementType("DOT_EXPR");
  IElementType DO_BLOCK = new NimElementType("DO_BLOCK");
  IElementType ENUM_DEF = new NimElementType("ENUM_DEF");
  IElementType ENUM_MEMBER = new NimElementType("ENUM_MEMBER");
  IElementType ENUM_TYPE_CLASS = new NimElementType("ENUM_TYPE_CLASS");
  IElementType EXPR_STMT = new NimElementType("EXPR_STMT");
  IElementType FOR_STMT = new NimElementType("FOR_STMT");
  IElementType FROM_STMT = new NimElementType("FROM_STMT");
  IElementType GENERIC_PARAM = new NimElementType("GENERIC_PARAM");
  IElementType GROUPED_EXPR = new NimElementType("GROUPED_EXPR");
  IElementType IDENTIFIER = new NimElementType("IDENTIFIER");
  IElementType IDENTIFIER_DEF = new NimElementType("IDENTIFIER_DEF");
  IElementType IDENTIFIER_DEFS = new NimElementType("IDENTIFIER_DEFS");
  IElementType IDENTIFIER_EXPR = new NimElementType("IDENTIFIER_EXPR");
  IElementType IDENT_PRAGMA_PAIR = new NimElementType("IDENT_PRAGMA_PAIR");
  IElementType IF_EXPR = new NimElementType("IF_EXPR");
  IElementType IF_STMT = new NimElementType("IF_STMT");
  IElementType IMPORT_STMT = new NimElementType("IMPORT_STMT");
  IElementType INCLUDE_STMT = new NimElementType("INCLUDE_STMT");
  IElementType INFIX_EXPR = new NimElementType("INFIX_EXPR");
  IElementType ITERATOR_DEF = new NimElementType("ITERATOR_DEF");
  IElementType LET_SECT = new NimElementType("LET_SECT");
  IElementType LITERAL = new NimElementType("LITERAL");
  IElementType MACRO_DEF = new NimElementType("MACRO_DEF");
  IElementType NIL_TOKEN = new NimElementType("NIL_TOKEN");
  IElementType OBJECT_CTOR = new NimElementType("OBJECT_CTOR");
  IElementType OBJECT_DEF = new NimElementType("OBJECT_DEF");
  IElementType OBJECT_FIELDS = new NimElementType("OBJECT_FIELDS");
  IElementType OBJECT_TYPE_CLASS = new NimElementType("OBJECT_TYPE_CLASS");
  IElementType PATTERN = new NimElementType("PATTERN");
  IElementType PRAGMA = new NimElementType("PRAGMA");
  IElementType PRAGMA_STMT = new NimElementType("PRAGMA_STMT");
  IElementType PREFIX_EXPR = new NimElementType("PREFIX_EXPR");
  IElementType PROC_DEF = new NimElementType("PROC_DEF");
  IElementType PROC_EXPR = new NimElementType("PROC_EXPR");
  IElementType PROC_TYPE_CLASS = new NimElementType("PROC_TYPE_CLASS");
  IElementType PROC_TYPE_EXPR = new NimElementType("PROC_TYPE_EXPR");
  IElementType PTR_TYPE_CLASS = new NimElementType("PTR_TYPE_CLASS");
  IElementType PTR_TYPE_EXPR = new NimElementType("PTR_TYPE_EXPR");
  IElementType RAISE_STMT = new NimElementType("RAISE_STMT");
  IElementType REF_TYPE_CLASS = new NimElementType("REF_TYPE_CLASS");
  IElementType REF_TYPE_EXPR = new NimElementType("REF_TYPE_EXPR");
  IElementType RETURN_STMT = new NimElementType("RETURN_STMT");
  IElementType SET_OR_TABLE_CTOR = new NimElementType("SET_OR_TABLE_CTOR");
  IElementType STATIC_STMT = new NimElementType("STATIC_STMT");
  IElementType STATIC_TYPE_EXPR = new NimElementType("STATIC_TYPE_EXPR");
  IElementType STMT_LIST_EXPR = new NimElementType("STMT_LIST_EXPR");
  IElementType TEMPLATE_DEF = new NimElementType("TEMPLATE_DEF");
  IElementType TRY_STMT = new NimElementType("TRY_STMT");
  IElementType TUPLE_CTOR = new NimElementType("TUPLE_CTOR");
  IElementType TUPLE_DEF = new NimElementType("TUPLE_DEF");
  IElementType TUPLE_TYPE_CLASS = new NimElementType("TUPLE_TYPE_CLASS");
  IElementType TUPLE_TYPE_EXPR = new NimElementType("TUPLE_TYPE_EXPR");
  TypeDefStubElementType TYPE_DEF = new TypeDefStubElementType();
  IElementType TYPE_DESC = new NimElementType("TYPE_DESC");
  IElementType TYPE_SECT = new NimElementType("TYPE_SECT");
  IElementType VAR_DEF = new NimElementType("VAR_DEF");
  IElementType VAR_SECT = new NimElementType("VAR_SECT");
  IElementType VAR_TYPE_CLASS = new NimElementType("VAR_TYPE_CLASS");
  IElementType VAR_TYPE_EXPR = new NimElementType("VAR_TYPE_EXPR");
  IElementType WHEN_EXPR = new NimElementType("WHEN_EXPR");
  IElementType WHEN_STMT = new NimElementType("WHEN_STMT");
  IElementType WHILE_STMT = new NimElementType("WHILE_STMT");
  IElementType YIELD_STMT = new NimElementType("YIELD_STMT");


  TokenSet COMMENTS = TokenSet.create(BLOCK_COMMENT, LINE_COMMENT);

  TokenSet STRINGS = TokenSet.create(STRING_LITERAL, CHARACTER_LITERAL, TRIPLESTR_LITERAL);

  TokenSet KEYWORDS = TokenSet.create(T_ADDR, T_AND, T_AS, T_ASM, T_ATOMIC, T_BIND, T_BLOCK, T_BREAK, T_CASE, T_CAST,
      T_CONCEPT, T_CONST, T_CONTINUE, T_CONVERTER, T_DEFER, T_DISCARD, T_DISTINCT, T_DIV, T_DO, T_ELIF, T_ELSE, T_END,
      T_ENUM, T_EXCEPT, T_EXPORT, T_FINALLY, T_FOR, T_FROM, T_FUNC, T_GENERIC, T_IF, T_IMPORT, T_IN, T_INCLUDE,
      T_INTERFACE, T_IS, T_ISNOT, T_ITERATOR, T_LET, T_MACRO, T_METHOD, T_MIXIN, T_MOD, T_NIL, T_NOT, T_NOTIN, T_OBJECT,
      T_OF, T_OR, T_OUT, T_PROC, T_PTR, T_RAISE, T_REF, T_RETURN, T_SHL, T_SHR, T_STATIC, T_TEMPLATE, T_TRY, T_TUPLE,
      T_TYPE, T_USING, T_VAR, T_WHEN, T_WHILE, T_WITH, T_WITHOUT, T_XOR, T_YIELD);

  TokenSet NUMBER_LITERALS = TokenSet.create(FLOAT64_LITERAL, FLOAT32_LITERAL, FLOAT_LITERAL,
      UINT64_LITERAL, UINT32_LITERAL, UINT16_LITERAL, UINT8_LITERAL, UINT_LITERAL,
      INT64_LITERAL, INT32_LITERAL, INT16_LITERAL, INT8_LITERAL, INT_LITERAL);

  TokenSet LITERALS = TokenSet.orSet(NUMBER_LITERALS, STRINGS);
}
