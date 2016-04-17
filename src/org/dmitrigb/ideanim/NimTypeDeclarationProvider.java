package org.dmitrigb.ideanim;

import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider;
import com.intellij.psi.PsiElement;
import org.dmitrigb.ideanim.types.Type;
import org.dmitrigb.ideanim.types.Types;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NimTypeDeclarationProvider implements TypeDeclarationProvider {
  @Nullable
  @Override
  public PsiElement[] getSymbolTypeDeclarations(@NotNull PsiElement symbol) {
    Type declType = Types.getDeclarationType(symbol);
    if (declType != null) {
      PsiElement def = Types.resolveDefinition(declType);
      if (def != null)
        return new PsiElement[]{def};
    }
    return null;
  }
}
