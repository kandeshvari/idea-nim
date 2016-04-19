package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.AsmStmt;

public class AsmStmtImpl extends BaseStatement implements AsmStmt {
  public AsmStmtImpl(ASTNode node) {
    super(node);
  }
}
