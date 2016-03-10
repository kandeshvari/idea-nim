// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VarDef extends PsiElement {

  @Nullable
  Expression getExpression();

  @NotNull
  List<IdentPragmaPair> getIdentPragmaPairList();

  @Nullable
  TypeDesc getTypeDesc();

}
