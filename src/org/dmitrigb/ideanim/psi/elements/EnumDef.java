package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EnumDef extends PsiElement {

  @NotNull
  List<Expression> getExpressionList();

  @NotNull
  List<Identifier> getIdentifierList();

}
