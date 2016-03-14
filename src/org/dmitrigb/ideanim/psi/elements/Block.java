package org.dmitrigb.ideanim.psi.elements;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Block extends PsiElement {

  @NotNull
  List<Statement> getStatementList();

}
