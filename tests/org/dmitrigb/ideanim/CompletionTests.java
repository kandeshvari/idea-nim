package org.dmitrigb.ideanim;

import java.util.List;

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import org.jetbrains.annotations.NotNull;

public class CompletionTests extends LightPlatformCodeInsightFixtureTestCase {
  public void testObjectMembers() throws Exception {
    List<String> strings = getCompletionStrings("" +
        "type\n" +
        "  Person = object of RootObj\n" +
        "    name: string\n" +
        "  Student = object of Person\n" +
        "    school: string\n" +
        "\n" +
        "proc enroll(p: Student, school: string) = discard\n" +
        "\n" +
        "var s: Student\n" +
        "s.<caret>\n");
    assertSameElements(strings, "name", "school", "enroll");
  }

  public void testTypes() throws Exception {
    List<String> strings = getCompletionStrings("" +
        "type\n" +
        "  A = object\n" +
        "  Foo = int\n" +
        "proc bar[Bah]() =\n" +
        "  var a: <caret>\n");
    assertContainsElements(strings, "A", "Foo", "Bah", "int", "string");
  }

  public void testTypesInTupleTypeExpr() throws Exception {
    List<String> strings = getCompletionStrings("" +
        "type\n" +
        "  A = object\n" +
        "  Foo = int\n" +
        "proc bar[Bah]() =\n" +
        "  var a: (<caret>)\n");
    assertContainsElements(strings, "A", "Foo", "Bah", "int", "string");
  }

  @NotNull
  private List<String> getCompletionStrings(String nimSource) {
    myFixture.configureByText(NimFileType.INSTANCE, nimSource);
    myFixture.completeBasic();
    List<String> strings = myFixture.getLookupElementStrings();
    assertNotNull(strings);
    return strings;
  }
}
