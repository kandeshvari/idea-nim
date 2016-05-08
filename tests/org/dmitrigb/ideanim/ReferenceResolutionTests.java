package org.dmitrigb.ideanim;

import java.util.List;
import java.util.stream.Collectors;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.dmitrigb.ideanim.psi.NimFile;
import org.dmitrigb.ideanim.psi.ProcResultPsiElement;
import org.dmitrigb.ideanim.psi.elements.*;

public class ReferenceResolutionTests extends BaseNimTests {
  public void testSimpleVariableResolution1() throws Exception {
    myFixture.configureByText(NimFileType.INSTANCE, "" +
        "var a = 3\n" +
        "discard <caret>a\n");
    PsiReference ref = myFixture.getReferenceAtCaretPositionWithAssertion();
    PsiElement target = ref.resolve();
    assertPsiAncestors(target, IdentifierDef.class, IdentPragmaPair.class, VarDef.class);
  }

  public void testSimpleVariableResolution2() throws Exception {
    myFixture.configureByText(NimFileType.INSTANCE, "" +
        "var a = 3\n" +
        "echo(<caret>a)\n");
    PsiReference ref = myFixture.getReferenceAtCaretPositionWithAssertion();
    PsiElement target = ref.resolve();
    assertPsiAncestors(target, IdentifierDef.class, IdentPragmaPair.class, VarDef.class);
  }

  public void testGenericType() throws Exception {
    PsiElement target = resolveReferenceIn("proc foo[T](a: <caret>T) = discard");
    assertPsiAncestors(target, IdentifierDef.class, GenericParam.class);
  }

  public void testEnum() throws Exception {
    PsiElement target = resolveReferenceIn("" +
        "type E = enum\n" +
        "  e1, e2\n" +
        "discard <caret>e2");
    assertPsiAncestors(target, EnumMember.class);
  }

  public void testSimpleProcResolution() throws Exception {
    assertResolvesToSecondProc("" +
        "proc bar() = discard\n" +
        "proc foo() = discard\n" +
        "<caret>foo()\n");
  }

  public void testOverloadedProcResolutionByArgCount() throws Exception {
    assertResolvesToSecondProc("" +
        "proc foo() = discard\n" +
        "proc foo(a: int) = discard\n" +
        "<caret>foo(3)\n");
  }

  public void testOverloadedProcResolutionByExactType1() throws Exception {
    assertResolvesToSecondProc("" +
        "proc foo(a: int) = discard\n" +
        "proc foo(a: string) = discard\n" +
        "<caret>foo(\"bar\")\n");
  }

  public void testOverloadedProcResolutionByExactType2() throws Exception {
    assertResolvesToSecondProc("" +
        "proc foo(a: string) = discard\n" +
        "proc foo(a: int) = discard\n" +
        "<caret>foo(42)\n");
  }

  public void testOverloadedProcResolutionByLiteralConversion() throws Exception {
    assertResolvesToSecondProc("" +
        "proc foo(a: string) = discard\n" +
        "proc foo(a: int) = discard\n" +
        "<caret>foo(42'i16)\n");
  }

  public void testOverloadedProcResolutionByGenericType() throws Exception {
    assertResolvesToSecondProc("" +
        "proc foo(a: string) = discard\n" +
        "proc foo[T](a: T) = discard\n" +
        "<caret>foo(42)\n");
  }

  public void testOverloadedProcBySubtype() throws Exception {
    assertResolvesToSecondProc("" +
        "type\n" +
        "  A = object of RootObj\n" +
        "  B = object of A\n" +
        "proc foo(a: string) = discard\n" +
        "proc foo(a: A) = discard\n" +
        "var b: B\n" +
        "<caret>foo(b)\n");
  }

  public void testObjectMember() throws Exception {
    assertResolvesToObjectMember("name", "" +
        "type Foo = object\n" +
        "  name: string\n" +
        "var f: Foo\n" +
        "discard f.<caret>name\n");
  }

  public void testObjectMemberRef() throws Exception {
    assertResolvesToObjectMember("name", "" +
        "type Foo = ref object\n" +
        "  name: string\n" +
        "var f: Foo\n" +
        "discard f.<caret>name\n");
  }

  public void testObjectMemberVar() throws Exception {
    assertResolvesToObjectMember("name", "" +
        "type Foo = object\n" +
        "  name: string\n" +
        "var f: var Foo\n" +
        "discard f.<caret>name\n");
  }

  public void testObjectMemberInherited() throws Exception {
    assertResolvesToObjectMember("name", "" +
        "type\n" +
        "  Foo = object of RootObj\n" +
        "    name: string\n" +
        "  Bar = object of Foo\n" +
        "var b: Bar\n" +
        "discard b.<caret>name\n");
  }

  public void testObjectMemberInCtor() throws Exception {
    assertResolvesToObjectMember("name", "" +
        "type Foo = object\n" +
        "  name: string\n" +
        "discard Foo(<caret>name: \"sad\")\n");
  }

  public void testObjectMemberInCtorIgnoreProcs() throws Exception {
    PsiElement target = resolveReferenceIn("" +
        "type A = object\n" +
        "proc foo(a: A) = discard\n" +
        "discard A(<caret>foo: 1)\n");
    assertNull(target);
  }

  public void testMethodCall() throws Exception {
    PsiElement target = resolveReferenceIn("" +
        "proc foo(a: string) = discard\n" +
        "\"bar\".<caret>foo()\n");
    assertPsiAncestors(target, ProcDef.class);
  }

  public void testShadowedParam() throws Exception {
    PsiElement target = resolveReferenceIn("" +
        "proc foo(a: int) =\n" +
        "  var a = <caret>a\n");
    assertPsiAncestors(target, IdentifierDef.class, IdentPragmaPair.class, IdentifierDefs.class, ProcDef.class);
  }

  public void testProcResult() throws Exception {
    PsiElement target = resolveReferenceIn("" +
        "proc foo(): int =\n" +
        "  <caret>result = 0\n");
    assertPsiAncestors(target, ProcResultPsiElement.class);
  }

  public void testPragma() throws Exception {
    myFixture.configureByText(NimFileType.INSTANCE, "" +
        "proc push() = discard\n" +
        "{.<caret>push.}\n");
    assertNull(myFixture.getReferenceAtCaretPosition());
  }

  private PsiElement resolveReferenceIn(String nimSource) {
    myFixture.configureByText(NimFileType.INSTANCE, nimSource);
    return myFixture.getReferenceAtCaretPositionWithAssertion().resolve();
  }

  private void assertResolvesToObjectMember(String memberName, String nimSource) {
    myFixture.configureByText(NimFileType.INSTANCE, nimSource);
    PsiReference ref = myFixture.getReferenceAtCaretPositionWithAssertion();
    PsiElement target = ref.resolve();
    assertPsiAncestors(target, IdentifierDef.class, IdentPragmaPair.class, ObjectFields.class);
    assertEquals(memberName, target.getText());
  }

  private void assertResolvesToSecondProc(String nimSource) {
    myFixture.configureByText(NimFileType.INSTANCE, nimSource);
    PsiReference ref = myFixture.getReferenceAtCaretPositionWithAssertion();
    PsiElement target = ref.resolve();
    assertPsiAncestors(target, ProcDef.class);
    List<Statement> procs = ((NimFile) myFixture.getFile()).getStatements().stream()
        .filter(s -> s instanceof ProcDef).collect(Collectors.toList());
    if (target != procs.get(1))
      fail("Reference at caret did not resolve to the correct procedure definition.");
  }

  @SafeVarargs
  private static void assertPsiAncestors(PsiElement element, Class<? extends PsiElement>... ancestorTypes) {
    for (Class<? extends PsiElement> type : ancestorTypes) {
      if (!type.isInstance(element))
        fail("Element <" + element + "> is not of type " + type.getSimpleName());
      element = element.getParent();
    }
  }
}
