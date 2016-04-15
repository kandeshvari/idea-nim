package org.dmitrigb.ideanim.psi;

import java.util.ArrayList;
import java.util.List;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.util.PsiTreeUtil;
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
  private List<Expression> callArgs;

  public MemberReference(@NotNull Expression expression, @NotNull Identifier identifier) {
    super(identifier);
    this.expression = expression;
  }

  public MemberReference(@NotNull Expression expression, @NotNull Identifier identifier, List<Expression> callArgs) {
    super(identifier);
    this.expression = expression;
    this.callArgs = callArgs;
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    Type type = expression.getType();
    if (type instanceof TVar)
      type = ((TVar) type).getBaseType();
    if (type instanceof TRef)
      type = ((TRef) type).getBaseType();
    if ((type instanceof TObject)) {
      MemberResolver resolver = new MemberResolver(getElement());
      ResolveState state = ResolveState.initial();
      TObject tObj = (TObject) type;
      ObjectDef objDef = tObj.getObject();
      while (objDef != null) {
        if (!objDef.processDeclarations(resolver, state, null, tObj.getObject()))
          return resolver.getResolvedTarget();
        objDef = NimPsiTreeUtil.getSuperTypeDef(objDef);
      }
    }

    // No matching field found, try to resolve to a proc
    List<Expression> args = new ArrayList<>();
    args.add(expression);
    if (callArgs != null)
      args.addAll(callArgs);
    RoutineResolver resolver = new RoutineResolver(getElement(), args);
    PsiTreeUtil.treeWalkUp(resolver, getElement(), null, ResolveState.initial());
    return resolver.getResolvedTarget();
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }
}
