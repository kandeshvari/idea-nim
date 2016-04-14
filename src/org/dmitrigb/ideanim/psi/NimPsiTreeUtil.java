package org.dmitrigb.ideanim.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import org.dmitrigb.ideanim.psi.elements.ObjectDef;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.dmitrigb.ideanim.types.TObject;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.Nullable;

public abstract class NimPsiTreeUtil {

  @Nullable
  public static ObjectDef getSuperTypeDef(ObjectDef objectDef) {
    TypeDesc superTypeDesc = objectDef.getSuperType();
    if (superTypeDesc == null)
      return null;
    Type superType = superTypeDesc.toType();
    if (superType instanceof TObject)
      return ((TObject) superType).getObject();

    return null;
  }

  public static RoutineDef getForwardDeclaration(RoutineDef routine) {
    SymbolResolver resolver = new SymbolResolver(routine.getIdentifier());
    routine.getContext().processDeclarations(resolver, ResolveState.initial(), null, routine);
    PsiElement target = resolver.getResolvedTarget();
    if (target instanceof RoutineDef && ((RoutineDef) target).isForwardDeclaration())
      return (RoutineDef) target;
    return null;
  }

  public static RoutineDef getFullDefinition(RoutineDef routine) {
    SymbolResolver resolver = new SymbolResolver(routine.getIdentifier()) {
      @Override
      protected boolean accept(PsiElement element, ResolveState state) {
        return element instanceof RoutineDef && !((RoutineDef) element).isForwardDeclaration();
      }
    };
    routine.getContext().processDeclarations(resolver, ResolveState.initial(), null, routine);
    PsiElement target = resolver.getResolvedTarget();
    if (target instanceof RoutineDef)
      return (RoutineDef) target;
    return null;
  }
}
