package org.dmitrigb.ideanim.types;

import com.intellij.psi.PsiElement;

public abstract class Types {
  public static PsiElement resolveDefinition(Type type) {
    if (type instanceof TRef)
      type = ((TRef) type).getBaseType();
    if (type instanceof TVar)
      type = ((TVar) type).getBaseType();
    if (type instanceof TObject)
      return type.getDefinition();
    return null;
  }
}
