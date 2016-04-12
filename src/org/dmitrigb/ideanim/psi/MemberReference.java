package org.dmitrigb.ideanim.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.ObjectDef;
import org.dmitrigb.ideanim.types.TObject;
import org.dmitrigb.ideanim.types.TRef;
import org.dmitrigb.ideanim.types.TVar;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MemberReference extends IdentifierReference {

  private Expression expression;

  public MemberReference(@NotNull Expression expression, @NotNull Identifier identifier) {
    super(identifier);
    this.expression = expression;
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    Type type = expression.getType();
    if (type instanceof TRef)
      type = ((TRef) type).getBaseType();
    if (type instanceof TVar)
      type = ((TVar) type).getBaseType();
    if (!(type instanceof TObject))
      return null;

    TObject tObj = (TObject) type;
    ObjectDef objDef = tObj.getDefinition();

    MemberResolver resolver = new MemberResolver(getElement());
    ResolveState state = ResolveState.initial();

    while (objDef != null) {
      if (!objDef.processDeclarations(resolver, state, null, tObj.getDefinition()))
        return resolver.getResolvedTarget();

      objDef = NimPsiTreeUtil.getSuperTypeDef(objDef);
    }

    return null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }
}
