// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RoutineDef extends Statement {

  @Nullable
  GenericParameters getGenericParameters();

  @Nullable
  Identifier getIdentifier();

  @Nullable
  Pattern getPattern();

  @Nullable
  Pragma getPragma();

  @NotNull
  List<IdentifierDefs> getParameterList();

  @Nullable
  TypeDesc getReturnType();

  @Nullable
  Block getBody();

}
