package org.dmitrigb.ideanim;

import java.util.List;

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import org.dmitrigb.ideanim.psi.NimFile;
import org.dmitrigb.ideanim.psi.elements.DiscardStmt;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.psi.elements.Statement;
import org.dmitrigb.ideanim.types.TPrimitive;
import org.dmitrigb.ideanim.types.Type;

public class TypeTests extends LightPlatformCodeInsightFixtureTestCase {
  public void testVariableWithDeclaredType() throws Exception {
    Type type = getTypeOfDiscardedExpr("" +
        "var a: string\n" +
        "discard a\n");
    assertEquals(TPrimitive.STRING, type);
  }

  public void testParameterWithDeclaredType() throws Exception {
    Type type = getTypeOfDiscardedExpr("" +
        "proc foo(a: int) =\n" +
        "  discard a\n");
    assertEquals(TPrimitive.INT, type);
  }

  public void testVariableWithInitializer() throws Exception {
    Type type = getTypeOfDiscardedExpr("" +
        "var a = \"foo\"\n" +
        "discard a\n");
    assertEquals(TPrimitive.STRING, type);
  }

  public void testProcCall() throws Exception {
    Type type = getTypeOfDiscardedExpr("" +
        "proc foo(): int = return 0\n" +
        "discard foo()\n");
    assertEquals(TPrimitive.INT, type);
  }

  public void testProcCallMethodSyntax() throws Exception {
    Type type = getTypeOfDiscardedExpr("" +
        "proc foo(s: string): int = return 0\n" +
        "discard \"\".foo()\n");
    assertEquals(TPrimitive.INT, type);
  }

  public void testObjectField() throws Exception {
    Type type = getTypeOfDiscardedExpr("" +
        "type Person = object\n" +
        "  name: string\n" +
        "var p: Person\n" +
        "discard p.name\n");
    assertEquals(TPrimitive.STRING, type);
  }

  private Type getTypeOfDiscardedExpr(String nimSource) {
    myFixture.configureByText(NimFileType.INSTANCE, nimSource);
    List<Statement> statements = ((NimFile) myFixture.getFile()).getStatements();
    Statement lastStmt = statements.get(statements.size() - 1);
    if (lastStmt instanceof RoutineDef) {
      statements = ((RoutineDef) lastStmt).getBody().getStatements();
      lastStmt = statements.get(statements.size() - 1);
    }
    Expression expr = ((DiscardStmt) lastStmt).getExpression();
    return expr.getType();
  }
}
