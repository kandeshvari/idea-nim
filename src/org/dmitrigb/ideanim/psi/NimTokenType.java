package org.dmitrigb.ideanim.psi;

import org.dmitrigb.ideanim.NimLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import com.intellij.psi.tree.IElementType;

public class NimTokenType extends IElementType {
  public NimTokenType(@NotNull @NonNls String debugName) {
    super(debugName, NimLanguage.INSTANCE);
  }
}
