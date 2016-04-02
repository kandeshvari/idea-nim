package org.dmitrigb.ideanim.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
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

  public static RoutineDef getForwardDeclaration(RoutineDef routine) {
    SymbolResolver resolver = new SymbolResolver(routine.getIdentifier());
    routine.getContext().processDeclarations(resolver, ResolveState.initial(), null, routine);
    PsiElement target = resolver.getResolvedTarget();
    if (target instanceof RoutineDef && ((RoutineDef) target).isForwardDeclaration())
      return (RoutineDef) target;
    return null;
  }

  public static RoutineDef getFullDefinition(RoutineDef routine) {
    SymbolResolver resolver = new SymbolResolver(routine.getIdentifier());
    resolver.setFullDefinitionOnly(true);
    routine.getContext().processDeclarations(resolver, ResolveState.initial(), null, routine);
    PsiElement target = resolver.getResolvedTarget();
    if (target instanceof RoutineDef)
      return (RoutineDef) target;
    return null;
  }
}
