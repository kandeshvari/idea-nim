package org.dmitrigb.ideanim;

import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.KeyWithDefaultValue;

public interface ResolveStateKeys {
  Key<Boolean> IN_UNREACHABLE_SCOPE = KeyWithDefaultValue.create("IN_UNREACHABLE_SCOPE", false);
}
