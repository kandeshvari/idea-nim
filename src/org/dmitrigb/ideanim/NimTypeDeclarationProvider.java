package org.dmitrigb.ideanim;

import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider;
import com.intellij.psi.PsiElement;
import org.dmitrigb.ideanim.psi.elements.TypeDesc;
import org.dmitrigb.ideanim.psi.elements.TypedElement;
import org.dmitrigb.ideanim.types.Types;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NimTypeDeclarationProvider implements TypeDeclarationProvider {
  @Nullable
  @Override
  public PsiElement[] getSymbolTypeDeclarations(@NotNull PsiElement symbol) {
    System.out.println("getSymbolTypeDeclarations: symbol=" + symbol);
    if (symbol instanceof TypedElement) {
      TypeDesc typeDesc = ((TypedElement) symbol).getDeclaredType();
      if (typeDesc != null) {
        PsiElement def = Types.resolveDefinition(typeDesc.toType());
        if (def != null)
          return new PsiElement[]{def};
      }
    }
    return null;
  }
}
