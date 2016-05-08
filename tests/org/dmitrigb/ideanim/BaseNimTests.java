package org.dmitrigb.ideanim;

import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.SdkModificator;
import com.intellij.openapi.projectRoots.impl.ProjectJdkImpl;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import org.jetbrains.annotations.Nullable;

public abstract class BaseNimTests extends LightPlatformCodeInsightFixtureTestCase {

  private Sdk nimSdk;

  private LightProjectDescriptor projectDescriptor;

  private Sdk createSdk() {
    Sdk sdk = new ProjectJdkImpl("Nim test SDK", new NimSdkType());
    SdkModificator modificator = sdk.getSdkModificator();
    VirtualFile sdkPath = LocalFileSystem.getInstance().findFileByPath(getTestDataPath() + "/sdk");
    modificator.addRoot(sdkPath, OrderRootType.SOURCES);
    modificator.commitChanges();
    return sdk;
  }

  @Override
  protected String getTestDataPath() {
    return "testdata";
  }

  @Override
  protected LightProjectDescriptor getProjectDescriptor() {
    if (projectDescriptor == null)
      projectDescriptor = new LightProjectDescriptor() {
        @Nullable
        @Override
        public Sdk getSdk() {
          if (nimSdk == null)
            nimSdk = createSdk();
          return nimSdk;
        }
      };
    return projectDescriptor;
  }

}
