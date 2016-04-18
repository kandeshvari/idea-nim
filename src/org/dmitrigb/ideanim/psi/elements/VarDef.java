package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VarDef extends PsiElement {

  @NotNull
  List<IdentPragmaPair> getIdentifiers();

  @Nullable
  TypeDesc getDeclaredType();

  @Nullable
  Expression getInitializer();

  boolean isVarTuple();

}
