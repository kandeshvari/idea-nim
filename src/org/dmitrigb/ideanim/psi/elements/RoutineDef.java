package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.StubBasedPsiElement;
import org.dmitrigb.ideanim.psi.stubs.RoutineDefStub;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface RoutineDef extends Statement, PsiNameIdentifierOwner, StubBasedPsiElement<RoutineDefStub> {

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

  int getParameterCount();

  int getMinParameterCount();

  int getMaxParameterCount();

  boolean hasParams();

}
