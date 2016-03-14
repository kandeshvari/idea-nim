package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;

public interface PrefixExpr extends Expression {

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
