package org.dmitrigb.ideanim.psi;

import java.util.List;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import org.dmitrigb.ideanim.NimFileType;
import org.dmitrigb.ideanim.NimLanguage;
import org.dmitrigb.ideanim.psi.elements.Statement;
import org.jetbrains.annotations.NotNull;

public class NimFile extends PsiFileBase {
  public NimFile(@NotNull FileViewProvider fileViewProvider) {
    super(fileViewProvider, NimLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return NimFileType.INSTANCE;
  }

  public List<Statement> getStatements() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, Statement.class);
  }

  @Override
  public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
    for (Statement statement : getStatements()) {
      if (statement == lastParent)
        return true;
      if (!statement.processDeclarations(processor, state, null, place))
        return false;
    }
    return true;
  }
}
