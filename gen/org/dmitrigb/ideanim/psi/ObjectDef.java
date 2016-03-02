// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ObjectDef extends PsiElement {

  @Nullable
  Expression getExpression();

  @NotNull
  List<Pragma> getPragmaList();

  @NotNull
  List<Symbol> getSymbolList();

  @NotNull
  List<TypeDesc> getTypeDescList();

}
