package org.dmitrigb.ideanim.psi.elements.impl;

import java.util.HashMap;
import java.util.Map;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import org.apache.commons.lang.StringEscapeUtils;
import org.dmitrigb.ideanim.psi.elements.Literal;
import org.dmitrigb.ideanim.types.TPrimitive;
import org.jetbrains.annotations.NotNull;

import static org.dmitrigb.ideanim.psi.ElementTypes.*;

public class LiteralImpl extends BaseExpression implements Literal {

  private static Map<IElementType, TPrimitive> literalTypes = new HashMap<>();

  static {
    literalTypes.put(INT_LITERAL, TPrimitive.INT);
    literalTypes.put(INT8_LITERAL, TPrimitive.INT8);
    literalTypes.put(INT16_LITERAL, TPrimitive.INT16);
    literalTypes.put(INT32_LITERAL, TPrimitive.INT32);
    literalTypes.put(INT64_LITERAL, TPrimitive.INT64);
    literalTypes.put(UINT_LITERAL, TPrimitive.UINT);
    literalTypes.put(UINT8_LITERAL, TPrimitive.UINT8);
    literalTypes.put(UINT16_LITERAL, TPrimitive.UINT16);
    literalTypes.put(UINT32_LITERAL, TPrimitive.UINT32);
    literalTypes.put(UINT64_LITERAL, TPrimitive.UINT64);
    literalTypes.put(FLOAT_LITERAL, TPrimitive.FLOAT);
    literalTypes.put(FLOAT32_LITERAL, TPrimitive.FLOAT32);
    literalTypes.put(FLOAT64_LITERAL, TPrimitive.FLOAT64);
    literalTypes.put(BOOL_LITERAL, TPrimitive.BOOL);
    literalTypes.put(CHARACTER_LITERAL, TPrimitive.CHAR);
    literalTypes.put(STRING_LITERAL, TPrimitive.STRING);
    literalTypes.put(TRIPLESTR_LITERAL, TPrimitive.STRING);
  }

  public LiteralImpl(ASTNode node) {
    super(node);
  }

  @Override
  public TPrimitive getType() {
    TPrimitive type = literalTypes.get(getLiteralElementType());
    assert type != null;
    return type;
  }

  @NotNull
  private IElementType getLiteralElementType() {
    return getFirstChild().getNode().getElementType();
  }

  @Override
  public long integerValue() {
    String text = getText().toLowerCase().replace("_", "");
    int pos = text.indexOf('\'');
    if (pos >= 0)
      text = text.substring(0, pos);

    if (text.startsWith("0x"))
      return Long.parseUnsignedLong(text.substring(2), 16);

    pos = text.indexOf('u');
    if (pos < 0)
      pos = text.indexOf('i');
    if (pos >= 0)
      text = text.substring(0, pos);

    if (text.startsWith("0o") || text.startsWith("0c"))
      return Long.parseUnsignedLong(text.substring(2), 8);

    if (text.startsWith("0b"))
      return Long.parseUnsignedLong(text.substring(2), 2);

    return Long.parseUnsignedLong(text, 10);
  }

  @Override
  public double floatValue() {
    String text = getText().toLowerCase().replace("_", "");
    int pos = text.indexOf('\'');
    if (pos >= 0)
      text = text.substring(0, pos);

    if (text.startsWith("0x"))
      return Double.longBitsToDouble(Long.parseUnsignedLong(text.substring(2), 16));

    pos = text.indexOf('f');
    if (pos < 0)
      pos = text.indexOf('d');
    if (pos >= 0)
      text = text.substring(0, pos);

    if (text.startsWith("0o") || text.startsWith("0c"))
      return Double.longBitsToDouble(Long.parseUnsignedLong(text.substring(2), 8));

    if (text.startsWith("0b"))
      return Double.longBitsToDouble(Long.parseUnsignedLong(text.substring(2), 2));

    return Double.parseDouble(text);
  }

  @Override
  public boolean boolValue() {
    if (getLiteralElementType() != BOOL_LITERAL)
      throw new IllegalStateException("Not a boolean literal");
    return "true".equals(getText());
  }

  @Override
  public char charValue() {
    if (getLiteralElementType() != CHARACTER_LITERAL)
      throw new IllegalStateException("Not a character literal");
    String text = getText();
    return StringEscapeUtils.unescapeJava(text.substring(1, text.length() - 1)).charAt(0);
  }

  @Override
  public String stringValue() {
    String text = getText();
    if (getLiteralElementType() == STRING_LITERAL)
      return StringEscapeUtils.unescapeJava(text.substring(1, text.length() - 1));
    if (getLiteralElementType() == TRIPLESTR_LITERAL)
      return text.substring(3, text.length() - 3);
    throw new IllegalStateException("Not a string literal");
  }

  @Override
  public Object primitiveValue() {
    TPrimitive type = getType();
    if (type.isInteger())
      return integerValue();
    if (type.isFloat())
      return floatValue();
    if (type.isChar())
      return charValue();
    if (type.isBool())
      return boolValue();
    assert type.isString();
    return stringValue();
  }
}
