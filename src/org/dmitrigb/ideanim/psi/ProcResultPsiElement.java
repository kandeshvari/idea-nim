package org.dmitrigb.ideanim.psi;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.ResolveState;
import com.intellij.psi.impl.PsiElementBase;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.psi.elements.IdentifierDef;
import org.dmitrigb.ideanim.psi.elements.ProcDef;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A pseudo PSI-element that represents the "declaration" of the implicit <i>result</i> variable.
 * Used as a target when resolving a reference to <i>result</i>.
 * Every {@link ProcDef proc} has a unique instance of this class.
 */
public class ProcResultPsiElement extends PsiElementBase implements IdentifierDef {

  private PsiElement routine;

  public ProcResultPsiElement(PsiElement routine) {
    this.routine = routine;
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    return processor.execute(this, state);
  }

  @NotNull
  @Override
  public Language getLanguage() {
    return routine.getLanguage();
  }

  @NotNull
  @Override
  public PsiElement[] getChildren() {
    return new PsiElement[0];
  }

  @Override
  public PsiElement getParent() {
    return routine;
  }

  @Override
  public TextRange getTextRange() {
    return TextRange.EMPTY_RANGE;
  }

  @Override
  public int getStartOffsetInParent() {
    return 0;
  }

  @Override
  public int getTextLength() {
    return 0;
  }

  @Nullable
  @Override
  public PsiElement findElementAt(int offset) {
    return null;
  }

  @Override
  public int getTextOffset() {
    return 0;
  }

  @Override
  public String getText() {
    return null;
  }

  @NotNull
  @Override
  public char[] textToCharArray() {
    return new char[0];
  }

  @Override
  public ASTNode getNode() {
    return null;
  }

  @Override
  public PsiManager getManager() {
    return routine.getManager();
  }

  @NotNull
  @Override
  public PsiElement getNavigationElement() {
    return routine;
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    throw new IncorrectOperationException();
  }

  @Override
  public String getName() {
    return "result";
  }
}
