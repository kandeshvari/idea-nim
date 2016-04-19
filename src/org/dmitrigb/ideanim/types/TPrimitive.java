package org.dmitrigb.ideanim.types;

import java.util.EnumSet;
import java.util.Set;

public class TPrimitive extends Type {
  private enum Kind {
    INT, INT8, INT16, INT32, INT64,
    UINT, UINT8, UINT16, UINT32, UINT64,
    FLOAT, FLOAT32, FLOAT64,
    CHAR, STRING, CSTRING,
    POINTER, BOOL, NIL, VOID
  }

  private static final EnumSet<Kind> SIGNED_INT_KINDS = EnumSet.of(Kind.INT, Kind.INT8, Kind.INT16, Kind.INT32, Kind.INT64);
  private static final EnumSet<Kind> UNSIGNED_INT_KINDS = EnumSet.of(Kind.UINT, Kind.UINT8, Kind.UINT16, Kind.UINT32, Kind.UINT64);
  private static final EnumSet<Kind> FLOAT_KINDS = EnumSet.of(Kind.FLOAT, Kind.FLOAT32, Kind.FLOAT64);

  public static final TPrimitive INT = new TPrimitive(Kind.INT);
  public static final TPrimitive INT8 = new TPrimitive(Kind.INT8);
  public static final TPrimitive INT16 = new TPrimitive(Kind.INT16);
  public static final TPrimitive INT32 = new TPrimitive(Kind.INT32);
  public static final TPrimitive INT64 = new TPrimitive(Kind.INT64);
  public static final TPrimitive UINT = new TPrimitive(Kind.UINT);
  public static final TPrimitive UINT8 = new TPrimitive(Kind.UINT8);
  public static final TPrimitive UINT16 = new TPrimitive(Kind.UINT16);
  public static final TPrimitive UINT32 = new TPrimitive(Kind.UINT32);
  public static final TPrimitive UINT64 = new TPrimitive(Kind.UINT64);
  public static final TPrimitive FLOAT = new TPrimitive(Kind.FLOAT);
  public static final TPrimitive FLOAT32 = new TPrimitive(Kind.FLOAT32);
  public static final TPrimitive FLOAT64 = new TPrimitive(Kind.FLOAT64);
  public static final TPrimitive BOOL = new TPrimitive(Kind.BOOL);
  public static final TPrimitive CHAR = new TPrimitive(Kind.CHAR);
  public static final TPrimitive STRING = new TPrimitive(Kind.STRING);
  public static final TPrimitive CSTRING = new TPrimitive(Kind.CSTRING);

  private Kind kind;

  private TPrimitive(Kind kind) {
    this.kind = kind;
  }

  @Override
  protected boolean equals(Type other, Set<TypePair> s) {
    return other instanceof TPrimitive && kind == ((TPrimitive) other).kind;
  }

  public boolean isInteger() {
    return isSignedInteger() || isUnsignedInteger();
  }

  public boolean isSignedInteger() {
    return SIGNED_INT_KINDS.contains(kind);
  }

  public boolean isUnsignedInteger() {
    return UNSIGNED_INT_KINDS.contains(kind);
  }

  public boolean isFloat() {
    return FLOAT_KINDS.contains(kind);
  }

  public boolean isChar() {
    return kind == Kind.CHAR;
  }

  public boolean isBool() {
    return kind == Kind.BOOL;
  }

  public boolean isString() {
    return kind == Kind.STRING;
  }

  public static Type fromPredefinedTypeName(String typeName) {
    switch (typeName) {
      case "int": return INT;
      case "int8": return INT8;
      case "int16": return INT16;
      case "int32": return INT32;
      case "int64": return INT64;
      case "uint": return UINT;
      case "uint8": return UINT8;
      case "uint16": return UINT16;
      case "uint32": return UINT32;
      case "uint64": return UINT64;
      case "float": return FLOAT;
      case "float32": return FLOAT32;
      case "float64": return FLOAT64;
      case "bool": return BOOL;
      case "char": return CHAR;
      case "string": return STRING;
      case "cstring": return CSTRING;
      default: return UNKNOWN;
    }
  }

  public boolean isInRange(long n, boolean unsigned) {
    long lb = 0, ub = 0;
    switch (kind) {
      case INT:
        lb = Integer.MIN_VALUE;
        ub = Integer.MAX_VALUE;
        break;
      case INT8:
        lb = Byte.MIN_VALUE;
        ub = Byte.MAX_VALUE;
        break;
      case INT16:
        lb = Short.MIN_VALUE;
        ub = Short.MAX_VALUE;
        break;
      case INT32:
        lb = Integer.MIN_VALUE;
        ub = Integer.MAX_VALUE;
        break;
      case INT64:
        lb = Long.MIN_VALUE;
        ub = Long.MAX_VALUE;
        break;
      case UINT:
        ub = 0xffffffffL;
        break;
      case UINT8:
        ub = 0xffL;
        break;
      case UINT16:
        ub = 0xffffL;
        break;
      case UINT32:
        ub = 0xffffffffL;
        break;
      case UINT64:
        ub = unsigned ? -1 : Long.MAX_VALUE;
        break;
      default:
        throw new IllegalStateException("Not an integer");
    }

    if (unsigned)
      return Long.compareUnsigned(n, ub) <= 0;

    return lb <= n && n <= ub;
  }

  @Override
  public String toString() {
    return kind.toString().toLowerCase();
  }
}
