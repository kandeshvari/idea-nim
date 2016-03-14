package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ObjectDef extends PsiElement {

  @NotNull
  List<Expression> getExpressionList();

  @NotNull
  List<IdentPragmaPair> getIdentPragmaPairList();

  @Nullable
  Identifier getIdentifier();

  @NotNull
  List<Pragma> getPragmaList();

  @NotNull
  List<TypeDesc> getTypeDescList();

}
