package org.dmitrigb.ideanim;

import org.dmitrigb.ideanim.psi.NimTypes;
import org.jetbrains.annotations.NotNull;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class NimSyntaxHighlighter extends SyntaxHighlighterBase {

  public static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
  public static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[] {
      createTextAttributesKey("NIM_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
  };
  public static final TextAttributesKey[] BLOCK_COMMENT_KEYS = new TextAttributesKey[] {
      createTextAttributesKey("NIM_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
  };
  public static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[] {
      createTextAttributesKey("NIM_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
  };
  public static final TextAttributesKey[] STRINGLIT_KEYS = new TextAttributesKey[] {
      createTextAttributesKey("NIM_STRING", DefaultLanguageHighlighterColors.STRING)
  };
  public static final TextAttributesKey[] NUMBERLIT_KEYS = new TextAttributesKey[] {
      createTextAttributesKey("NIM_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
  };
  
  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    return new NimLexerAdapter();
  }

  @NotNull
  @Override
  public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
    if (tokenType.equals(NimTypes.LINE_COMMENT))
      return LINE_COMMENT_KEYS;
    if (tokenType.equals(NimTypes.BLOCK_COMMENT))
      return BLOCK_COMMENT_KEYS;
    if (NimTypes.KEYWORDS.contains(tokenType))
      return KEYWORD_KEYS;
    if (NimTypes.STRINGS.contains(tokenType))
      return STRINGLIT_KEYS;
    if (tokenType.equals(NimTypes.NUMBER_LITERAL))
      return NUMBERLIT_KEYS;
    return EMPTY_KEYS;
  }
}
