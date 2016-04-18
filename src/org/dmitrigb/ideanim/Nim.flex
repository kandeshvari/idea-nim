package org.dmitrigb.ideanim;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.intellij.psi.TokenType.*;
import static org.dmitrigb.ideanim.psi.ElementTypes.*;

/**
 * A lexer for lexing Nim source.
 */
%%

%unicode
%class NimLexer
%implements FlexLexer
%public
%function advance
%type IElementType
%eof{
  return;
%eof}

%{
  int blockCommentNestingLevel = 0;
%}

WHITE_SPACE_CHAR = [\ \n\r\t\f]

IDENT = ([:letter:] | [\u2013]) ("_"? ([:letter:] | [:digit:] | [\u2013]))*

LINE_COMMENT = "#" [^\r\n]* (\r? \n [\ \t]* "#" [^\r\n]*)*

HEX_LIT = "0" [xX] [0-9A-Fa-f] [0-9A-Fa-f_]*
DEC_LIT = [0-9] [0-9_]*
OCT_LIT = "0" [ocC] [0-7] [0-7_]*
BIN_LIT = "0" [bB] [01] [01_]*

INT_LITERAL     = {HEX_LIT} | {DEC_LIT} | {OCT_LIT} | {BIN_LIT}
INT8_LITERAL    = {INT_LITERAL} \'? [iI] "8"
INT16_LITERAL   = {INT_LITERAL} \'? [iI] "16"
INT32_LITERAL   = {INT_LITERAL} \'? [iI] "32"
INT64_LITERAL   = {INT_LITERAL} \'? [iI] "64"
UINT_LITERAL    = {INT_LITERAL} \'? [uU]
UINT8_LITERAL   = {UINT_LITERAL} "8"
UINT16_LITERAL  = {UINT_LITERAL} "16"
UINT32_LITERAL  = {UINT_LITERAL} "32"
UINT64_LITERAL  = {UINT_LITERAL} "64"

EXPONENT = [Ee] [-+]? [0-9] [0-9_]*
FLOAT_LITERAL   = [0-9] [0-9_]* (("." [0-9_]+ {EXPONENT}?) | {EXPONENT})
FLOAT32_SUFFIX = [fF] "32"?
FLOAT32_LITERAL = {HEX_LIT} \' {FLOAT32_SUFFIX}
                | ({FLOAT_LITERAL} | {DEC_LIT} | {OCT_LIT} | {BIN_LIT}) \'? {FLOAT32_SUFFIX}
FLOAT64_SUFFIX = [fF] "64" | [dD]
FLOAT64_LITERAL = {HEX_LIT} \' {FLOAT64_SUFFIX}
                | ({FLOAT_LITERAL} | {DEC_LIT} | {OCT_LIT} | {BIN_LIT}) \'? {FLOAT64_SUFFIX}

BOOL_LITERAL = "true" | "false"

CHARACTER_LITERAL = \' (\\. | [^\\\'\r\n])* \'?
STRING_LITERAL = \" (\\. | [^\\\"\r\n])* \"?
TRIPLESTR_LITERAL = \"\"\" ([^\"]+ | \"\"? [^\"]+)* \"*\"\"\"

ACCENT_QUOTED = ` [^`\r\n]* `

OP_CHAR = [\+\-\*\/\\\<\>\!\?\^\.\|=%&\$@\~:]

%state ST_BLOCK_COMMENT

%%

<YYINITIAL> {
  {WHITE_SPACE_CHAR}+ { return WHITE_SPACE; }
  
  "#[" { blockCommentNestingLevel = 1; yybegin(ST_BLOCK_COMMENT); return BLOCK_COMMENT; }
  
  {LINE_COMMENT} { return LINE_COMMENT; }

  {FLOAT64_LITERAL} { return FLOAT64_LITERAL; }
  {FLOAT32_LITERAL} { return FLOAT32_LITERAL; }
  {FLOAT_LITERAL}   { return FLOAT_LITERAL; }
  {UINT64_LITERAL}  { return UINT64_LITERAL; }
  {UINT32_LITERAL}  { return UINT32_LITERAL; }
  {UINT16_LITERAL}  { return UINT16_LITERAL; }
  {UINT8_LITERAL}   { return UINT8_LITERAL; }
  {UINT_LITERAL}    { return UINT_LITERAL; }
  {INT64_LITERAL}   { return INT64_LITERAL; }
  {INT32_LITERAL}   { return INT32_LITERAL; }
  {INT16_LITERAL}   { return INT16_LITERAL; }
  {INT8_LITERAL}    { return INT8_LITERAL; }
  {INT_LITERAL}     { return INT_LITERAL; }

  {BOOL_LITERAL} { return BOOL_LITERAL; }
  {CHARACTER_LITERAL} { return CHARACTER_LITERAL; }
  {TRIPLESTR_LITERAL} { return TRIPLESTR_LITERAL; }
  {STRING_LITERAL} { return STRING_LITERAL; }

  {ACCENT_QUOTED} { return ACCENT_QUOTED; }


  // Operators (3 or more characters)
  {OP_CHAR}{OP_CHAR}{OP_CHAR}+ { return OPERATOR; }
  // Operators (2 characters), excluding "*:"
  \* [\+\-\*\/\\\<\>\!\?\^\.\|=%&\$@\~] | [\+\-\/\\\<\>\!\?\^\.\|=%&\$@\~:]{OP_CHAR} {
    if (yytext().equals("::"))
      return T_DBLCOLON;
    if (yytext().equals(".."))
      return T_DOTDOT;
    return OPERATOR;
  }
  // Single charecter operators, excluding ".", ":" and "="
  [\+\-\*\/\\\<\>\!\?\^\|%&\$@\~] { return OPERATOR; }

  "{." { return T_BRACEDOT; }
  ".}" { return T_DOTBRACE; }

  ";" { return T_SEMICOLON; }
  ":" { return T_COLON; }
  "," { return T_COMMA; }
  "." { return T_DOT; }
  "=" { return T_EQ; }
  "(" { return T_LPAREN; }
  ")" { return T_RPAREN; }
  "[" { return T_LBRACKET; }
  "]" { return T_RBRACKET; }
  "{" { return T_LBRACE; }
  "}" { return T_RBRACE; }
  //"`" { return T_ACCENT; }


  "addr" { return T_ADDR; }
  "and" { return T_AND; }
  "as" { return T_AS; }
  "asm" { return T_ASM; }
  "atomic" { return T_ATOMIC; }
  "bind" { return T_BIND; }
  "block" { return T_BLOCK; }
  "break" { return T_BREAK; }
  "case" { return T_CASE; }
  "cast" { return T_CAST; }
  "concept" { return T_CONCEPT; }
  "const" { return T_CONST; }
  "continue" { return T_CONTINUE; }
  "converter" { return T_CONVERTER; }
  "defer" { return T_DEFER; }
  "discard" { return T_DISCARD; }
  "distinct" { return T_DISTINCT; }
  "div" { return T_DIV; }
  "do" { return T_DO; }
  "elif" { return T_ELIF; }
  "else" { return T_ELSE; }
  "end" { return T_END; }
  "enum" { return T_ENUM; }
  "except" { return T_EXCEPT; }
  "export" { return T_EXPORT; }
  "finally" { return T_FINALLY; }
  "for" { return T_FOR; }
  "from" { return T_FROM; }
  "func" { return T_FUNC; }
  "generic" { return T_GENERIC; }
  "if" { return T_IF; }
  "import" { return T_IMPORT; }
  "in" { return T_IN; }
  "include" { return T_INCLUDE; }
  "interface" { return T_INTERFACE; }
  "is" { return T_IS; }
  "isnot" { return T_ISNOT; }
  "iterator" { return T_ITERATOR; }
  "let" { return T_LET; }
  "macro" { return T_MACRO; }
  "method" { return T_METHOD; }
  "mixin" { return T_MIXIN; }
  "mod" { return T_MOD; }
  "nil" { return T_NIL; }
  "not" { return T_NOT; }
  "notin" { return T_NOTIN; }
  "object" { return T_OBJECT; }
  "of" { return T_OF; }
  "or" { return T_OR; }
  "out" { return T_OUT; }
  "proc" { return T_PROC; }
  "ptr" { return T_PTR; }
  "raise" { return T_RAISE; }
  "ref" { return T_REF; }
  "return" { return T_RETURN; }
  "shl" { return T_SHL; }
  "shr" { return T_SHR; }
  "static" { return T_STATIC; }
  "template" { return T_TEMPLATE; }
  "try" { return T_TRY; }
  "tuple" { return T_TUPLE; }
  "type" { return T_TYPE; }
  "using" { return T_USING; }
  "var" { return T_VAR; }
  "when" { return T_WHEN; }
  "while" { return T_WHILE; }
  "with" { return T_WITH; }
  "without" { return T_WITHOUT; }
  "xor" { return T_XOR; }
  "yield" { return T_YIELD; }

  {IDENT} { return IDENT; }

  [^] { return BAD_CHARACTER; }
}

<ST_BLOCK_COMMENT> {
  "#[" { blockCommentNestingLevel++; return BLOCK_COMMENT; }
  "]#" {
      if (--blockCommentNestingLevel == 0) yybegin(YYINITIAL);
      return BLOCK_COMMENT;
  }
  [^] { return BLOCK_COMMENT; }
}