package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.BindStmt;

public class BindStmtImpl extends BaseStatement implements BindStmt {
  public BindStmtImpl(ASTNode node) {
    super(node);
  }
}
