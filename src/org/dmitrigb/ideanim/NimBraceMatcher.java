package org.dmitrigb.ideanim;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.dmitrigb.ideanim.psi.ElementTypes.*;

public class NimBraceMatcher implements PairedBraceMatcher {

  private static final BracePair[] BRACE_PAIRS = new BracePair[]{
      new BracePair(T_LPAREN, T_RPAREN, false),
      new BracePair(T_LBRACKET, T_RBRACKET, false),
      new BracePair(T_LBRACE, T_RBRACE, false),
  };

  @Override
  public BracePair[] getPairs() {
    return BRACE_PAIRS;
  }

  @Override
  public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
    return true;
  }

  @Override
  public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
    return 0;
  }
}
