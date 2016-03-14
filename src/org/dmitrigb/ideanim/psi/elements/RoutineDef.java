package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.*;

public interface RoutineDef extends Statement, PsiNamedElement {

  @Nullable
  GenericParameters getGenericParameters();

  @Nullable
  Identifier getIdentifier();

  @Nullable
  Pattern getPattern();

  @Nullable
  Pragma getPragma();

  @NotNull
  List<IdentifierDefs> getParameters();

  @Nullable
  TypeDesc getReturnType();

  @Nullable
  Block getBody();

}
