package org.dmitrigb.ideanim;

import com.intellij.lexer.FlexAdapter;

public class NimLexerAdapter extends FlexAdapter {
  public NimLexerAdapter() {
    super(new NimLexer(null));
  }
}
