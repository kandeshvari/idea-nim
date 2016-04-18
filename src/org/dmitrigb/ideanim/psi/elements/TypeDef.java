package org.dmitrigb.ideanim.psi.elements;

import java.util.List;

import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.StubBasedPsiElement;
import org.dmitrigb.ideanim.psi.stubs.TypeDefStub;
import org.dmitrigb.ideanim.types.Type;
import org.jetbrains.annotations.*;

public interface TypeDef extends PsiNameIdentifierOwner, StubBasedPsiElement<TypeDefStub> {

  @NotNull
  Identifier getIdentifier();

  @NotNull
  List<GenericParam> getGenericParameters();

  @Nullable
  Pragma getPragma();

  Expression getDefinition();

  Type toType();
}
