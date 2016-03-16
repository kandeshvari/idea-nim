package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

public interface ObjectMember extends ObjectPart {

  List<IdentPragmaPair> getIdentifiers();

  TypeDesc getTypeDesc();

  Expression getInitializer();
}
