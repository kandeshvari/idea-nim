package org.dmitrigb.ideanim.psi;

import org.dmitrigb.ideanim.NimFileType;
import org.dmitrigb.ideanim.NimLanguage;
import org.jetbrains.annotations.NotNull;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;

import static org.dmitrigb.ideanim.ResolveStateKeys.IN_UNREACHABLE_SCOPE;

public class NimFile extends PsiFileBase {
  public NimFile(@NotNull FileViewProvider fileViewProvider) {
    super(fileViewProvider, NimLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return NimFileType.INSTANCE;
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    if (lastParent != null) {
      PsiElement[] children = getChildren();
      for (PsiElement child : children) {
        if (child == lastParent) {
          state = state.put(IN_UNREACHABLE_SCOPE, true);
          continue;
        }
        boolean more = child.processDeclarations(processor, state, null, place);
        if (!more)
          return false;
      }
    }
    return true;
  }
}
