package org.dmitrigb.ideanim.psi.stubs;

import java.io.IOException;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import org.dmitrigb.ideanim.NimLanguage;
import org.dmitrigb.ideanim.psi.NimFile;
import org.dmitrigb.ideanim.psi.elements.Block;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.psi.elements.WhenStmt;
import org.dmitrigb.ideanim.psi.elements.impl.IteratorDefImpl;
import org.dmitrigb.ideanim.psi.elements.impl.MacroDefImpl;
import org.dmitrigb.ideanim.psi.elements.impl.ProcDefImpl;
import org.dmitrigb.ideanim.psi.elements.impl.TemplateDefImpl;
import org.dmitrigb.ideanim.psi.stubs.impl.RoutineDefStubImpl;
import org.dmitrigb.ideanim.psi.stubs.indices.RoutineIndex;
import org.jetbrains.annotations.NotNull;

public class RoutineDefElementType extends IStubElementType<RoutineDefStub, RoutineDef> {

  public enum Kind {
    PROC, ITERATOR, TEMPLATE, MACRO
  }

  private final Kind kind;

  public RoutineDefElementType(String debugName, Kind kind) {
    super(debugName, NimLanguage.INSTANCE);
    this.kind = kind;
  }

  @Override
  public RoutineDef createPsi(@NotNull RoutineDefStub stub) {
    switch (kind) {
      case PROC:
        return new ProcDefImpl(stub, this);
      case ITERATOR:
        return new IteratorDefImpl(stub, this);
      case TEMPLATE:
        return new TemplateDefImpl(stub, this);
      case MACRO:
        return new MacroDefImpl(stub, this);
    }
    throw new IllegalStateException("Unknown kind: " + kind);
  }

  @Override
  public boolean shouldCreateStub(ASTNode node) {
    RoutineDef routine = (RoutineDef) node.getPsi();
    if (routine.getName() == null)
      return false;
    PsiElement context = routine.getContext();
    while (context instanceof WhenStmt || context instanceof Block)
      context = context.getContext();
    return context instanceof NimFile;
  }

  @Override
  public RoutineDefStub createStub(@NotNull RoutineDef psi, StubElement parentStub) {
    String name = psi.getName();
    assert name != null;
    return new RoutineDefStubImpl(parentStub, this, name, psi.hasParams());
  }

  @NotNull
  @Override
  public String getExternalId() {
    return "nim.ROUTINE_DEF." + kind;
  }

  @Override
  public void serialize(@NotNull RoutineDefStub stub, @NotNull StubOutputStream dataStream) throws IOException {
    dataStream.writeName(stub.getName());
    dataStream.writeBoolean(stub.hasParams());
  }

  @NotNull
  @Override
  public RoutineDefStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
    String name = dataStream.readName().getString();
    assert name != null;
    boolean hasParams = dataStream.readBoolean();
    return new RoutineDefStubImpl(parentStub, this, name, hasParams);
  }

  @Override
  public void indexStub(@NotNull RoutineDefStub stub, @NotNull IndexSink sink) {
    String name = stub.getName();
    assert name != null;
    sink.occurrence(RoutineIndex.KEY, name);
  }
}
