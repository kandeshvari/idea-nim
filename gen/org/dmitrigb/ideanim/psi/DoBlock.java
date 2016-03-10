// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DoBlock extends PsiElement {

  @Nullable
  Block getBlock();

  @NotNull
  List<IdentifierDefs> getIdentifierDefsList();

  @Nullable
  Pragma getPragma();

  @Nullable
  TypeDesc getTypeDesc();

}
