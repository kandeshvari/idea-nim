package org.dmitrigb.ideanim;

import java.util.List;

import org.jetbrains.annotations.NotNull;

public class CompletionTests extends BaseNimTests {
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
        "proc setGPA(p: var Student, gpa: int) = discard\n" +
        "\n" +
        "var s: Student\n" +
        "s.<caret>\n");
    assertSameElements(strings, "name", "school", "enroll", "setGPA");
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

  public void testProcOnEnum() throws Exception {
    List<String> strings = getCompletionStrings("" +
        "type E = enum V\n" +
        "proc foo(e: E) = discard\n" +
        "var e: E\n" +
        "e.<caret>\n");
    assertSameElements(strings, "foo");
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
