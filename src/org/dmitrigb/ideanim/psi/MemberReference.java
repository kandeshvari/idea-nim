package org.dmitrigb.ideanim.psi;

import java.util.List;

import com.intellij.psi.PsiElement;
import org.dmitrigb.ideanim.psi.elements.*;
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
    TypeDef type = expression.resolveType();
    if (type == null)
      return null;

    Expression definition = type.getDefinition();

    while (definition != null) {
      if (definition instanceof RefTypeExpr)
        definition = ((RefTypeExpr) definition).getExpression();

      if (!(definition instanceof ObjectDef))
        break;

      ObjectDef objDef = (ObjectDef) definition;
      List<ObjectPart> parts = objDef.getParts();
      for (ObjectPart part : parts) {
        if (part instanceof ObjectMember) {
          List<IdentPragmaPair> identifiers = ((ObjectMember) part).getIdentifiers();
          for (IdentPragmaPair ipp : identifiers) {
            if (ipp.getIdentifier().textMatches(getElement()))
              return ipp.getIdentifier();
          }
        }
      }
      TypeDesc superType = objDef.getSuperType();
      if (superType == null)
        break;
      TypeDef superDef = superType.getExpression().evaluateType();
      if (superDef == null)
        break;
      definition = superDef.getDefinition();
    }

    return null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }
}
