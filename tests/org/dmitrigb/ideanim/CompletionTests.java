package org.dmitrigb.ideanim;

import java.util.List;

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;

public class CompletionTests extends LightPlatformCodeInsightFixtureTestCase {
  public void testObjectMember() throws Exception {
    assertCompletionResult("" +
            "type\n" +
            "  Person = object of RootObj\n" +
            "    name: string\n" +
            "  Student = object of Person\n" +
            "    school: string\n" +
            "\n" +
            "proc enroll(p: Student, school: string) = discard\n" +
            "\n" +
            "var s: Student\n" +
            "s.<caret>\n",
        "name", "school", "enroll");
  }

  private void assertCompletionResult(String nimSource, String... expected) {
    myFixture.configureByText(NimFileType.INSTANCE, nimSource);
    myFixture.completeBasic();
    List<String> strings = myFixture.getLookupElementStrings();
    assertNotNull(strings);
    assertSameElements(strings, expected);
  }
}
