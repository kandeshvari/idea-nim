package org.dmitrigb.ideanim.psi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.dmitrigb.ideanim.NimSdkUtil;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.IdentifierExpr;

public class ImportProcessor extends SymbolProcessor {

  private List<String> modules = new ArrayList<>();

  public static GlobalSearchScope buildImportScope(PsiElement from) {
    ImportProcessor processor = new ImportProcessor();
    NimPsiTreeUtil.walkUp(processor, from);
    return processor.getImportScope(from.getProject(), NimSdkUtil.getSdk(from));
  }

  @Override
  protected boolean processImport(Expression expression) {
    if (expression instanceof IdentifierExpr)
      modules.add(expression.getText());
    return true;
  }

  public GlobalSearchScope getImportScope(Project project, Sdk sdk) {
    GlobalSearchScope scope = NimSdkUtil.getSystemModuleScope(project, sdk);
    if (scope == null)
      scope = GlobalSearchScope.EMPTY_SCOPE;

    for (String nimModule : modules) {
      Collection<VirtualFile> files = FilenameIndex.getVirtualFilesByName(project, nimModule + ".nim", GlobalSearchScope.allScope(project));
      scope = scope.uniteWith(GlobalSearchScope.filesScope(project, files));
    }
    return scope;
  }
}
