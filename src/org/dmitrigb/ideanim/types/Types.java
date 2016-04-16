package org.dmitrigb.ideanim.types;

import com.intellij.psi.PsiElement;

public abstract class Types {
  public static Type unwrapBaseType(Type type) {
    if (type instanceof TVar)
      return ((TVar) type).getBaseType();

    while (true) {
      if (type instanceof TRef) {
        type = ((TRef) type).getBaseType();
        continue;
      }
      break;
    }
    return type;
  }

  public static PsiElement resolveDefinition(Type type) {
    return unwrapBaseType(type).getDefinition();
  }

  public static boolean isSubtype(Type type, Type subtype) {
    if (type instanceof TObject && subtype instanceof TObject) {
      Type superType = ((TObject) subtype).getSuperType();
      while (superType instanceof TObject && !type.equals(superType))
        superType = ((TObject) superType).getSuperType();
      return type.equals(superType);
    }
    if (type instanceof TVar && subtype instanceof TVar)
      return isSubtype(((TVar) type).getBaseType(), ((TVar) subtype).getBaseType());
    if (type instanceof TRef && subtype instanceof TRef)
      return isSubtype(((TRef) type).getBaseType(), ((TRef) subtype).getBaseType());
    return false;
  }
}
