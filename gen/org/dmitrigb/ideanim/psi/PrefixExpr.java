// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrefixExpr extends Expression {

  @Nullable
  EnumDef getEnumDef();

  @NotNull
  List<Expression> getExpressionList();

  @Nullable
  ObjectDef getObjectDef();

  @Nullable
  ParamList getParamList();

  @Nullable
  Pragma getPragma();

  @Nullable
  PrefixExpr getPrefixExpr();

  @NotNull
  List<Statement> getStatementList();

  @NotNull
  List<Symbol> getSymbolList();

  @NotNull
  List<TypeDesc> getTypeDescList();

}
