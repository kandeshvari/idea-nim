package org.dmitrigb.ideanim.psi.elements;

public interface Literal extends Expression {
  long integerValue();
  double floatValue();

  char charValue();
  String stringValue();
  Object primitiveValue();
}
