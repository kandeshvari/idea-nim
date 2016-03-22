package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

public interface ObjectFields extends ObjectPart {

  List<IdentPragmaPair> getIdentifiers();

  TypeDesc getTypeDesc();

  Expression getInitializer();
}
