package org.dmitrigb.ideanim.psi.elements.impl;

import com.intellij.lang.ASTNode;
import org.dmitrigb.ideanim.psi.elements.FromStmt;

public class FromStmtImpl extends BaseStatement implements FromStmt {
  public FromStmtImpl(ASTNode node) {
    super(node);
  }
}
