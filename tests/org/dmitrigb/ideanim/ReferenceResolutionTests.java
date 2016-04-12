package org.dmitrigb.ideanim;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import org.dmitrigb.ideanim.psi.NimFile;
import org.dmitrigb.ideanim.psi.elements.IdentPragmaPair;
import org.dmitrigb.ideanim.psi.elements.IdentifierDef;
import org.dmitrigb.ideanim.psi.elements.ProcDef;
import org.dmitrigb.ideanim.psi.elements.VarDef;

public class ReferenceResolutionTests extends LightPlatformCodeInsightFixtureTestCase {
  @Override
  protected LightProjectDescriptor getProjectDescriptor() {
    return null;
  }

  public void testSimpleVariableResolution1() throws Exception {
    myFixture.configureByText(NimFileType.INSTANCE, "" +
        "var a = 3\n" +
        "<caret>a\n");
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

  private void assertResolvesToSecondProc(String nimSource) {
    myFixture.configureByText(NimFileType.INSTANCE, nimSource);
    PsiReference ref = myFixture.getReferenceAtCaretPositionWithAssertion();
    PsiElement target = ref.resolve();
    assertPsiAncestors(target, ProcDef.class);
    if (target != ((NimFile) myFixture.getFile()).getStatements().get(1))
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
