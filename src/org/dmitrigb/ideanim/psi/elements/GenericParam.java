package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface GenericParam extends PsiElement {
  @NotNull
  List<IdentifierDef> getIdentifers();

  @Nullable
  Expression getConstraints();

  @Nullable
  Expression getInitializer();
}
