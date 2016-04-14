package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

import com.intellij.psi.PsiNameIdentifierOwner;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.*;

public interface TypeDef extends PsiNameIdentifierOwner {

  @NotNull
  Identifier getIdentifier();

  @NotNull
  List<GenericParam> getGenericParameters();

  @Nullable
  Pragma getPragma();

  Expression getDefinition();

  Type toType();
}
