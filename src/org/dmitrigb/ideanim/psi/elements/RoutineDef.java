package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface RoutineDef extends Statement, PsiNameIdentifierOwner {

  @NotNull
  List<GenericParam> getGenericParameters();

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

  boolean isForwardDeclaration();

}
