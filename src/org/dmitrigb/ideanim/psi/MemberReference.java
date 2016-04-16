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
  private final boolean fieldsOnly;

  /**
   * A reference to a member of an object.
   * Using this constructor will create a reference that only resolves to fields, and not to procedures.
   * This is useful when resolving field references inside an object constructor.
   */
  public MemberReference(@NotNull Expression expression, @NotNull Identifier identifier) {
    super(identifier);
    this.expression = expression;
    fieldsOnly = true;
  }

  /**
   * A reference to a member of an object.
   * Using this constructor will create a reference that resolves to both - fields as well as procedures.
   */
  public MemberReference(@NotNull Expression expression, @NotNull Identifier identifier, @Nullable List<Expression> callArgs) {
    super(identifier);
    this.expression = expression;
    this.callArgs = callArgs;
    fieldsOnly = false;
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
    if (!fieldsOnly) {
      List<Expression> args = new ArrayList<>();
      args.add(expression);
      if (callArgs != null)
        args.addAll(callArgs);
      RoutineResolver resolver = new RoutineResolver(getElement(), args);
      NimPsiTreeUtil.walkUp(resolver, getElement(), null, getElement().getText());
      return resolver.getResolvedTarget();
    }

    return null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }
}
