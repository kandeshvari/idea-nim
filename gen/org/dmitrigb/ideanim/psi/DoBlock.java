// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DoBlock extends PsiElement {

  @Nullable
  ParamList getParamList();

  @Nullable
  Pragma getPragma();

  @NotNull
  List<Statement> getStatementList();

  @Nullable
  TypeDesc getTypeDesc();

}
