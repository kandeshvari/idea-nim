package org.dmitrigb.ideanim.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

public interface ElementTypes extends ElementTypesBase {
  IElementType T_DBLCOLON = new NimTokenType("T_DBLCOLON");

  IElementType T_ASM = new NimTokenType("T_ASM");
  IElementType T_ATOMIC = new NimTokenType("T_ATOMIC");
  IElementType T_CONCEPT = new NimTokenType("T_CONCEPT");
  IElementType T_CONVERTER = new NimTokenType("T_CONVERTER");
  IElementType T_END = new NimTokenType("T_END");
  IElementType T_EXPORT = new NimTokenType("T_EXPORT");
  IElementType T_FROM = new NimTokenType("T_FROM");
  IElementType T_FUNC = new NimTokenType("T_FUNC");
  IElementType T_GENERIC = new NimTokenType("T_GENERIC");
  IElementType T_INTERFACE = new NimTokenType("T_INTERFACE");
  IElementType T_METHOD = new NimTokenType("T_METHOD");
  IElementType T_USING = new NimTokenType("T_USING");
  IElementType T_WITH = new NimTokenType("T_WITH");
  IElementType T_WITHOUT = new NimTokenType("T_WITHOUT");

  IElementType BLOCK_COMMENT = new NimTokenType("BLOCK_COMMENT");
  IElementType LINE_COMMENT = new NimTokenType("LINE_COMMENT");

  TokenSet COMMENTS = TokenSet.create(BLOCK_COMMENT, LINE_COMMENT);

  TokenSet STRINGS = TokenSet.create(STRING_LITERAL, CHARACTER_LITERAL);

  TokenSet KEYWORDS = TokenSet.create(T_ADDR, T_AND, T_AS, T_ASM, T_ATOMIC, T_BIND, T_BLOCK, T_BREAK, T_CASE, T_CAST,
      T_CONCEPT, T_CONST, T_CONTINUE, T_CONVERTER, T_DEFER, T_DISCARD, T_DISTINCT, T_DIV, T_DO, T_ELIF, T_ELSE, T_END,
      T_ENUM, T_EXCEPT, T_EXPORT, T_FINALLY, T_FOR, T_FROM, T_FUNC, T_GENERIC, T_IF, T_IMPORT, T_IN, T_INCLUDE,
      T_INTERFACE, T_IS, T_ISNOT, T_ITERATOR, T_LET, T_MACRO, T_METHOD, T_MIXIN, T_MOD, T_NIL, T_NOT, T_NOTIN, T_OBJECT,
      T_OF, T_OR, T_OUT, T_PROC, T_PTR, T_RAISE, T_REF, T_RETURN, T_SHL, T_SHR, T_STATIC, T_TEMPLATE, T_TRY, T_TUPLE,
      T_TYPE, T_USING, T_VAR, T_WHEN, T_WHILE, T_WITH, T_WITHOUT, T_XOR, T_YIELD);

  TokenSet NUMBER_LITERALS = TokenSet.create(FLOAT64_LITERAL, FLOAT32_LITERAL, FLOAT_LITERAL,
      UINT64_LITERAL, UINT32_LITERAL, UINT16_LITERAL, UINT8_LITERAL, UINT_LITERAL,
      INT64_LITERAL, INT32_LITERAL, INT16_LITERAL, INT8_LITERAL, INT_LITERAL);

  TokenSet LITERALS = TokenSet.orSet(TokenSet.create(CHARACTER_LITERAL, STRING_LITERAL), NUMBER_LITERALS);
}
