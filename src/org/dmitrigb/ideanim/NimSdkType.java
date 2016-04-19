package org.dmitrigb.ideanim;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.intellij.openapi.projectRoots.*;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NimSdkType extends SdkType {
  public NimSdkType() {
    super("Nim");
  }

  @Nullable
  @Override
  public String suggestHomePath() {
    return null;
  }

  @Override
  public boolean isValidSdkHome(String path) {
    return new File(path, "lib/stdlib.nimble").exists();
  }

  @Override
  public String suggestSdkName(String currentSdkName, String sdkHome) {
    String version = getVersionString(sdkHome);
    return "Nim" + (version != null ? ' ' + version : "");
  }

  @Nullable
  @Override
  public String getVersionString(String sdkHome) {
    File stdlib = new File(sdkHome, "lib/stdlib.nimble");
    try {
      return Files.readAllLines(stdlib.toPath()).stream()
          .filter(l -> l.startsWith("version"))
          .findFirst()
          .map(s -> s.substring(s.indexOf('"') + 1, s.lastIndexOf('"')))
          .orElse(null);
    }
    catch (IOException ignored) {
    }
    return null;
  }

  @Override
  public void setupSdkPaths(@NotNull Sdk sdk) {
    SdkModificator modificator = sdk.getSdkModificator();
    LocalFileSystem fs = LocalFileSystem.getInstance();
    String homePath = sdk.getHomePath();
    assert homePath != null : sdk;
    VirtualFile libPath = fs.findFileByIoFile(new File(homePath, "lib"));
    modificator.removeRoots(OrderRootType.CLASSES);
    modificator.removeRoots(OrderRootType.SOURCES);
    modificator.addRoot(libPath, OrderRootType.CLASSES);
    modificator.addRoot(libPath, OrderRootType.SOURCES);
    modificator.commitChanges();
  }

  @Nullable
  @Override
  public AdditionalDataConfigurable createAdditionalDataConfigurable(@NotNull SdkModel sdkModel, @NotNull SdkModificator sdkModificator) {
    return null;
  }

  @NotNull
  @Override
  public String getPresentableName() {
    return "Nim";
  }

  @Override
  public void saveAdditionalData(@NotNull SdkAdditionalData additionalData, @NotNull Element additional) {

  }
}
