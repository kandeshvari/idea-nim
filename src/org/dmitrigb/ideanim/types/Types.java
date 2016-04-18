package org.dmitrigb.ideanim.types;

import com.intellij.psi.PsiElement;
import org.dmitrigb.ideanim.psi.NimPsiTreeUtil;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.IdentifierDef;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.dmitrigb.ideanim.psi.elements.VarDef;

public abstract class Types {
  public static Type derefType(Type type) {
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

  public static Type unwrapNamedTypes(Type type) {
    while (type instanceof NamedType) {
      type = ((NamedType) type).getUnderlyingType();
    }
    return type;
  }

  public static Type unwrapNamedAndDeref(Type type) {
    while (true) {
      Type prev = type;
      type = unwrapNamedTypes(derefType(type));
      if (type == prev)
        return type;
    }
  }

  public static PsiElement resolveDefinition(Type type) {
    Type baseType = derefType(type);
    if (baseType instanceof NamedType)
      return ((NamedType) baseType).getDefinition();
    return null;
  }

  public static boolean isSubtype(Type type, Type subtype) {
    type = Types.unwrapNamedTypes(type);
    subtype = Types.unwrapNamedTypes(subtype);
    if (type instanceof TObject && subtype instanceof TObject) {
      Type superType = subtype;
      while (superType instanceof TObject && !type.equals(superType)) {
        superType = unwrapNamedAndDeref(((TObject) superType).getSuperType());
      }
      return type.equals(superType);
    }
    if (type instanceof TVar && subtype instanceof TVar)
      return isSubtype(((TVar) type).getBaseType(), ((TVar) subtype).getBaseType());
    if (type instanceof TRef && subtype instanceof TRef)
      return isSubtype(((TRef) type).getBaseType(), ((TRef) subtype).getBaseType());
    return false;
  }

  /**
   * Returns the type of a symbol declaration.
   * @param declaration a declaration element (variable definition, proc parameter, field etc)
   */
  public static Type getDeclarationType(PsiElement declaration) {
    TypeDesc typeDesc = NimPsiTreeUtil.getDeclaredType(declaration);
    if (typeDesc != null)
      return typeDesc.toType();

    Expression initializer = null;
    if (declaration instanceof IdentifierDef) {
      PsiElement context = declaration.getContext();
      if (context instanceof VarDef && !((VarDef) context).isVarTuple())
        initializer = ((VarDef) context).getInitializer();
    }

    if (initializer != null)
      return initializer.getType();

    return Type.UNKNOWN;
  }
}
