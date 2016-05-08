package org.dmitrigb.ideanim.psi.stubs.indices;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.jetbrains.annotations.NotNull;

public class RoutineIndex extends StringStubIndexExtension<RoutineDef> {

  public static final StubIndexKey<String, RoutineDef> KEY = StubIndexKey.createIndexKey("nim.routines");

  public static final RoutineIndex INSTANCE = new RoutineIndex();

  @NotNull
  @Override
  public StubIndexKey<String, RoutineDef> getKey() {
    return KEY;
  }
}
