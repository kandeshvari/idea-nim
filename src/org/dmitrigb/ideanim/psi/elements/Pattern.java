package org.dmitrigb.ideanim.psi.elements;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Pattern extends PsiElement {

  @Nullable
  Block getBlock();

}
