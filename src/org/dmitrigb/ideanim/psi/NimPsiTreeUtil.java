package org.dmitrigb.ideanim.psi;

import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.Nullable;

public abstract class NimPsiTreeUtil {

  @Nullable
  public static ObjectDef getSuperTypeDef(ObjectDef objectDef) {
    TypeDesc superType = objectDef.getSuperType();
    if (superType == null)
      return null;
    Expression superDef = superType.getExpression().evaluateType(Expression.TypeEvalMode.DEREF_ALL);
    if (superDef instanceof ObjectDef)
      return (ObjectDef) superDef;

    return null;
  }

}
