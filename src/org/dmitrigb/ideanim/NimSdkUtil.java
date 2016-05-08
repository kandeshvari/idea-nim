package org.dmitrigb.ideanim;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;

public abstract class NimSdkUtil {
  public static Sdk getSdk(PsiElement element) {
    Module module = ModuleUtilCore.findModuleForPsiElement(element);
    if (module != null)
      return ModuleRootManager.getInstance(module).getSdk();
    return ProjectRootManager.getInstance(element.getProject()).getProjectSdk();
  }

  public static GlobalSearchScope getSystemModuleScope(Project project, Sdk sdk) {
    if (sdk == null)
      return null;
    VirtualFile systemModule = getSystemModule(sdk);
    return GlobalSearchScope.fileScope(project, systemModule);
  }

  @NotNull
  private static VirtualFile getSystemModule(@NotNull Sdk sdk) {
    VirtualFile[] roots = sdk.getRootProvider().getFiles(OrderRootType.SOURCES);
    assert roots.length == 1;
    VirtualFile systemFile = roots[0].findChild("system.nim");
    assert systemFile != null;
    return systemFile;
  }

}
