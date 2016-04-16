package org.dmitrigb.ideanim.psi.elements;

public interface StaticTypeExpr extends Expression {
  Expression getUnderlyingType();
}
