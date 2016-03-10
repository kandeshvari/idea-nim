// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IdentifierDefs extends PsiElement {

  @NotNull
  List<IdentPragmaPair> getIdentPragmaPairList();

  @Nullable
  TypeDesc getType();

  @Nullable
  Expression getInitializer();

}
