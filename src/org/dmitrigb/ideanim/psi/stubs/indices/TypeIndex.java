package org.dmitrigb.ideanim.psi.stubs.indices;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.jetbrains.annotations.NotNull;

public class TypeIndex extends StringStubIndexExtension<TypeDef> {

  public static final StubIndexKey<String, TypeDef> KEY = StubIndexKey.createIndexKey("nim.types");

  private static final TypeIndex INSTANCE = new TypeIndex();

  public static TypeIndex getInstance() {
    return INSTANCE;
  }

  @NotNull
  @Override
  public StubIndexKey<String, TypeDef> getKey() {
    return KEY;
  }
}
