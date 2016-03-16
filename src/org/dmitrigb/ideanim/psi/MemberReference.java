package org.dmitrigb.ideanim.psi;

import java.util.List;

import com.intellij.psi.PsiElement;
import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MemberReference extends IdentifierReference {

  private DotExpr dotExpr;

  public MemberReference(@NotNull DotExpr element) {
    super(element.getIdentifier());
    dotExpr = element;
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    TypeDef type = dotExpr.getExpression().resolveType();
    if (type == null)
      return null;
    System.out.println("Resolved type to: " + type.getIdentifier().getText());

    Expression definition = type.getDefinition();

    if (definition instanceof ObjectDef) {
      ObjectDef objDef = (ObjectDef) definition;
      List<ObjectPart> parts = objDef.getParts();
      for (ObjectPart part : parts) {
        if (part instanceof ObjectMember) {
          List<IdentPragmaPair> identifiers = ((ObjectMember) part).getIdentifiers();
          for (IdentPragmaPair ipp : identifiers) {
            if (ipp.getIdentifier().textMatches(dotExpr.getIdentifier()))
              return ipp.getIdentifier();
          }
        }
      }
    }

    return null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }
}
