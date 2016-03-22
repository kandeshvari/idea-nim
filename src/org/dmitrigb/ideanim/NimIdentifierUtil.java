package org.dmitrigb.ideanim;

public abstract class NimIdentifierUtil {
  public static String normalizeId(String identifier) {
    return identifier.charAt(0) + identifier.substring(1).replace("_", "").replace("\u2013", "").toLowerCase();
  }
}
