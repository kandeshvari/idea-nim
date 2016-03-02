package org.dmitrigb.ideanim;

import javax.swing.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.fileTypes.LanguageFileType;

public class NimFileType extends LanguageFileType {
  public static NimFileType INSTANCE = new NimFileType();

  public NimFileType() {
    super(NimLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "Nim";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Nim file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "nim";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return null;
  }
}
