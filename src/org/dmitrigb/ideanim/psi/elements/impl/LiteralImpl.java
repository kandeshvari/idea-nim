package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import org.apache.commons.lang.StringEscapeUtils;
import org.dmitrigb.ideanim.psi.ElementTypes;
import org.dmitrigb.ideanim.psi.elements.Literal;
import org.dmitrigb.ideanim.types.SystemTypes;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.NotNull;

import static org.dmitrigb.ideanim.psi.ElementTypes.*;

public class LiteralImpl extends BaseExpression implements Literal {

  public LiteralImpl(ASTNode node) {
    super(node);
  }

  @Override
  public Type getType() {
    IElementType el = getLiteralElementType();
    SystemTypes sysTypes = SystemTypes.getInstance(this);
    if (el == INT_LITERAL)
      return sysTypes.intType();
    if (el == INT8_LITERAL)
      return sysTypes.int8Type();
    if (el == INT16_LITERAL)
      return sysTypes.int16Type();
    if (el == INT32_LITERAL)
      return sysTypes.int32Type();
    if (el == INT64_LITERAL)
      return sysTypes.int64Type();
    if (el == UINT_LITERAL)
      return sysTypes.uintType();
    if (el == UINT8_LITERAL)
      return sysTypes.uint8Type();
    if (el == UINT16_LITERAL)
      return sysTypes.uint16Type();
    if (el == UINT32_LITERAL)
      return sysTypes.uint32Type();
    if (el == UINT64_LITERAL)
      return sysTypes.uint64Type();
    if (el == FLOAT_LITERAL)
      return sysTypes.floatType();
    if (el == FLOAT32_LITERAL)
      return sysTypes.float32Type();
    if (el == FLOAT64_LITERAL)
      return sysTypes.float64Type();
    if (el == CHARACTER_LITERAL)
      return sysTypes.charType();
    if (el == STRING_LITERAL || el == TRIPLESTR_LITERAL)
      return sysTypes.stringType();

    return Type.UNKNOWN;
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
    IElementType el = getLiteralElementType();

    if (ElementTypes.INTEGER_LITERALS.contains(el))
      return integerValue();

    if (ElementTypes.FLOAT_LITERALS.contains(el))
      return floatValue();

    if (el == CHARACTER_LITERAL)
      return charValue();

    assert ElementTypes.STRINGS.contains(el);
    return stringValue();
  }
}
