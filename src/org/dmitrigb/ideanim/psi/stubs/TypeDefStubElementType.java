package org.dmitrigb.ideanim.psi.stubs;

import java.io.IOException;

import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.io.StringRef;
import org.dmitrigb.ideanim.NimLanguage;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.dmitrigb.ideanim.psi.elements.impl.TypeDefImpl;
import org.dmitrigb.ideanim.psi.stubs.impl.TypeDefStubImpl;
import org.dmitrigb.ideanim.psi.stubs.indices.TypeIndex;
import org.jetbrains.annotations.NotNull;

public class TypeDefStubElementType extends IStubElementType<TypeDefStub, TypeDef> {
  public TypeDefStubElementType() {
    super("TYPE_DEF", NimLanguage.INSTANCE);
  }

  @Override
  public TypeDef createPsi(@NotNull TypeDefStub stub) {
    return new TypeDefImpl(stub, this);
  }

  @Override
  public TypeDefStub createStub(@NotNull TypeDef psi, StubElement parentStub) {
    return new TypeDefStubImpl(parentStub, psi.getName());
  }

  @NotNull
  @Override
  public String getExternalId() {
    return "nim.TYPE_DEF";
  }

  @Override
  public void serialize(@NotNull TypeDefStub stub, @NotNull StubOutputStream dataStream) throws IOException {
    dataStream.writeName(stub.getName());
  }

  @NotNull
  @Override
  public TypeDefStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
    StringRef name = dataStream.readName();
    assert name != null;
    return new TypeDefStubImpl(parentStub, name.getString());
  }

  @Override
  public void indexStub(@NotNull TypeDefStub stub, @NotNull IndexSink sink) {
    sink.occurrence(TypeIndex.KEY, stub.getName());
  }

  @Override
  public boolean shouldCreateStub(ASTNode node) {
    TypeDef typeDef = ((TypeDef) node.getPsi());
    return typeDef.getContext() == typeDef.getContainingFile();
  }
}
