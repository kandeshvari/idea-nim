// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.dmitrigb.ideanim.psi.NimTypesBase.*;
import org.dmitrigb.ideanim.psi.*;

public class LiteralImpl extends ExpressionImpl implements Literal {

  public LiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitLiteral(this);
    else super.accept(visitor);
  }

}
