package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.MixinStmt;

public class MixinStmtImpl extends BaseStatement implements MixinStmt {
  public MixinStmtImpl(ASTNode node) {
    super(node);
  }
}
