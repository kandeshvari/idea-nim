// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrefixExpr extends Expression {

  @Nullable
  Block getBlock();

  @Nullable
  EnumDef getEnumDef();

  @Nullable
  Expression getExpression();

  @NotNull
  List<IdentifierDef> getIdentifierDefList();

  @NotNull
  List<IdentifierDefs> getIdentifierDefsList();

  @Nullable
  ObjectDef getObjectDef();

  @Nullable
  Pragma getPragma();

  @NotNull
  List<TypeDesc> getTypeDescList();

}
