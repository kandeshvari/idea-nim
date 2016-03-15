package org.dmitrigb.ideanim.findUsages;

import org.dmitrigb.ideanim.NimLexerAdapter;
import org.dmitrigb.ideanim.psi.elements.ConstDef;
import org.dmitrigb.ideanim.psi.elements.IdentifierDef;
import org.dmitrigb.ideanim.psi.NimTypes;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;

public class NimFindUsagesProvider implements FindUsagesProvider {
  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    // TODO: use a custom words scanner to support Nim style identifier matching
    return new DefaultWordsScanner(new NimLexerAdapter(), TokenSet.create(NimTypes.IDENT), NimTypes.COMMENTS, NimTypes.LITERALS);
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement el) {
    return el instanceof RoutineDef || el instanceof IdentifierDef || el instanceof ConstDef || el instanceof TypeDef;
  }

  @Nullable
  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return null;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement psiElement) {
    return "symbol";
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement psiElement) {
    if (psiElement instanceof PsiNamedElement) {
      String name = ((PsiNamedElement) psiElement).getName();
      if (name != null)
        return name;
    }
    return psiElement.getText();
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement psiElement, boolean b) {
    if (psiElement instanceof PsiNamedElement)
      return ((PsiNamedElement) psiElement).getName();
    return psiElement.getText();
  }
}