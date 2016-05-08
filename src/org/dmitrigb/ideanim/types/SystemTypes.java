package org.dmitrigb.ideanim.types;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.UserDataHolder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.dmitrigb.ideanim.NimSdkUtil;
import org.dmitrigb.ideanim.psi.stubs.indices.TypeIndex;

public class SystemTypes {

  private static final Key<SystemTypes> USER_DATA_KEY = new Key<>(SystemTypes.class.getName());

  private Type intType = Type.UNKNOWN;
  private Type int8Type = Type.UNKNOWN;
  private Type int16Type = Type.UNKNOWN;
  private Type int32Type = Type.UNKNOWN;
  private Type int64Type = Type.UNKNOWN;
  private Type uintType = Type.UNKNOWN;
  private Type uint8Type = Type.UNKNOWN;
  private Type uint16Type = Type.UNKNOWN;
  private Type uint32Type = Type.UNKNOWN;
  private Type uint64Type = Type.UNKNOWN;
  private Type floatType = Type.UNKNOWN;
  private Type float32Type = Type.UNKNOWN;
  private Type float64Type = Type.UNKNOWN;
  private Type charType = Type.UNKNOWN;
  private Type stringType = Type.UNKNOWN;

  public static SystemTypes getInstance(PsiElement element) {
    Project project = element.getProject();
    UserDataHolder holder = project;
    Sdk sdk = NimSdkUtil.getSdk(element);
    if (sdk != null)
      holder = sdk;
    SystemTypes sysTypes = holder.getUserData(USER_DATA_KEY);
    if (sysTypes == null) {
      sysTypes = SystemTypes.create(sdk, project);
      holder.putUserData(USER_DATA_KEY, sysTypes);
    }
    return sysTypes;
  }

  private static SystemTypes create(Sdk sdk, Project project) {
    SystemTypes sysTypes = new SystemTypes();
    GlobalSearchScope sysModule = NimSdkUtil.getSystemModuleScope(project, sdk);
    if (sysModule != null) {
      TypeIndex index = TypeIndex.getInstance();
      sysTypes.intType = index.get("int", project, sysModule).iterator().next().toType();
      sysTypes.int8Type = index.get("int8", project, sysModule).iterator().next().toType();
      sysTypes.int16Type = index.get("int16", project, sysModule).iterator().next().toType();
      sysTypes.int32Type = index.get("int32", project, sysModule).iterator().next().toType();
      sysTypes.int64Type = index.get("int64", project, sysModule).iterator().next().toType();
      sysTypes.uintType = index.get("uint", project, sysModule).iterator().next().toType();
      sysTypes.uint8Type = index.get("uint8", project, sysModule).iterator().next().toType();
      sysTypes.uint16Type = index.get("uint16", project, sysModule).iterator().next().toType();
      sysTypes.uint32Type = index.get("uint32", project, sysModule).iterator().next().toType();
      sysTypes.uint64Type = index.get("uint64", project, sysModule).iterator().next().toType();
      sysTypes.floatType = index.get("float", project, sysModule).iterator().next().toType();
      sysTypes.float32Type = index.get("float32", project, sysModule).iterator().next().toType();
      sysTypes.float64Type = index.get("float64", project, sysModule).iterator().next().toType();
      sysTypes.charType = index.get("char", project, sysModule).iterator().next().toType();
      sysTypes.stringType = index.get("string", project, sysModule).iterator().next().toType();
    }
    return sysTypes;
  }

  private SystemTypes() {
  }

  public Type intType() {
    return intType;
  }

  public Type int8Type() {
    return int8Type;
  }

  public Type int16Type() {
    return int16Type;
  }

  public Type int32Type() {
    return int32Type;
  }

  public Type int64Type() {
    return int64Type;
  }

  public Type uintType() {
    return uintType;
  }

  public Type uint8Type() {
    return uint8Type;
  }

  public Type uint16Type() {
    return uint16Type;
  }

  public Type uint32Type() {
    return uint32Type;
  }

  public Type uint64Type() {
    return uint64Type;
  }

  public Type floatType() {
    return floatType;
  }

  public Type float32Type() {
    return float32Type;
  }

  public Type float64Type() {
    return float64Type;
  }

  public Type charType() {
    return charType;
  }

  public Type stringType() {
    return stringType;
  }
}
