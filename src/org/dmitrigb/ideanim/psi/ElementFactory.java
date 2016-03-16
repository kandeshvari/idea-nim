package org.dmitrigb.ideanim.psi;

import java.util.List;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import org.dmitrigb.ideanim.NimLanguage;
import org.dmitrigb.ideanim.psi.elements.ExprStmt;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.IdentifierExpr;
import org.dmitrigb.ideanim.psi.elements.Statement;
import org.dmitrigb.ideanim.psi.elements.impl.*;

import static org.dmitrigb.ideanim.psi.NimTypesBase.*;

public class ElementFactory {

  public static PsiElement createElement(ASTNode node) {
    IElementType type = node.getElementType();
    if (type == ASSIGNMENT_EXPR) {
      return new AssignmentExprImpl(node);
    }
    else if (type == BLOCK) {
      return new BlockImpl(node);
    }
    else if (type == BLOCK_STMT) {
      return new BlockStmtImpl(node);
    }
    else if (type == BRACKET_CTOR) {
      return new BracketCtorImpl(node);
    }
    else if (type == BRACKET_EXPR) {
      return new BracketExprImpl(node);
    }
    else if (type == BREAK_STMT) {
      return new BreakStmtImpl(node);
    }
    else if (type == CALL_EXPR) {
      return new CallExprImpl(node);
    }
    else if (type == CASE_EXPR) {
      return new CaseExprImpl(node);
    }
    else if (type == CASE_STMT) {
      return new CaseStmtImpl(node);
    }
    else if (type == CAST_EXPR) {
      return new CastExprImpl(node);
    }
    else if (type == COMMAND_EXPR) {
      return new CommandExprImpl(node);
    }
    else if (type == CONST_DEF) {
      return new ConstDefImpl(node);
    }
    else if (type == CONST_SECT) {
      return new ConstSectImpl(node);
    }
    else if (type == CTOR_ARG) {
      return new CtorArgImpl(node);
    }
    else if (type == DISCARD_STMT) {
      return new DiscardStmtImpl(node);
    }
    else if (type == DISTINCT_TYPE_EXPR) {
      return new DistinctTypeExprImpl(node);
    }
    else if (type == DOT_EXPR) {
      return new DotExprImpl(node);
    }
    else if (type == DO_BLOCK) {
      return new DoBlockImpl(node);
    }
    else if (type == ENUM_DEF) {
      return new EnumDefImpl(node);
    }
    else if (type == EXPR_STMT) {
      return new ExprStmtImpl(node);
    }
    else if (type == FOR_STMT) {
      return new ForStmtImpl(node);
    }
    else if (type == GENERIC_PARAMETERS) {
      return new GenericParametersImpl(node);
    }
    else if (type == GROUPED_EXPR) {
      return new GroupedExprImpl(node);
    }
    else if (type == IDENTIFIER) {
      return new IdentifierImpl(node);
    }
    else if (type == IDENTIFIER_DEF) {
      return new IdentifierDefImpl(node);
    }
    else if (type == IDENTIFIER_DEFS) {
      return new IdentifierDefsImpl(node);
    }
    else if (type == IDENTIFIER_EXPR) {
      return new IdentifierExprImpl(node);
    }
    else if (type == IDENT_PRAGMA_PAIR) {
      return new IdentPragmaPairImpl(node);
    }
    else if (type == IF_EXPR) {
      return new IfExprImpl(node);
    }
    else if (type == IF_STMT) {
      return new IfStmtImpl(node);
    }
    else if (type == IMPORT_STMT) {
      return new ImportStmtImpl(node);
    }
    else if (type == INFIX_EXPR) {
      return new InfixExprImpl(node);
    }
    else if (type == ITERATOR_DEF) {
      return new IteratorDefImpl(node);
    }
    else if (type == LET_SECT) {
      return new LetSectImpl(node);
    }
    else if (type == LITERAL) {
      return new LiteralImpl(node);
    }
    else if (type == NIL_TOKEN) {
      return new NilTokenImpl(node);
    }
    else if (type == OBJECT_CTOR) {
      return new ObjectCtorImpl(node);
    }
    else if (type == OBJECT_DEF) {
      return new ObjectDefImpl(node);
    }
    else if (type == OBJECT_MEMBER) {
      return new ObjectMemberImpl(node);
    }
    else if (type == PATTERN) {
      return new PatternImpl(node);
    }
    else if (type == PRAGMA) {
      return new PragmaImpl(node);
    }
    else if (type == PRAGMA_STMT) {
      return new PragmaStmtImpl(node);
    }
    else if (type == PREFIX_EXPR) {
      return new PrefixExprImpl(node);
    }
    else if (type == PROC_DEF) {
      return new ProcDefImpl(node);
    }
    else if (type == PROC_EXPR) {
      return new ProcExprImpl(node);
    }
    else if (type == PTR_TYPE_EXPR) {
      return new PtrTypeExprImpl(node);
    }
    else if (type == RAISE_STMT) {
      return new RaiseStmtImpl(node);
    }
    else if (type == REF_TYPE_EXPR) {
      return new RefTypeExprImpl(node);
    }
    else if (type == RETURN_STMT) {
      return new ReturnStmtImpl(node);
    }
    else if (type == SET_OR_TABLE_CTOR) {
      return new SetOrTableCtorImpl(node);
    }
    else if (type == STATIC_STMT) {
      return new StaticStmtImpl(node);
    }
    else if (type == STMT_LIST_EXPR) {
      return new StmtListExprImpl(node);
    }
    else if (type == TEMPLATE_DEF) {
      return new TemplateDefImpl(node);
    }
    else if (type == TRY_STMT) {
      return new TryStmtImpl(node);
    }
    else if (type == TUPLE_CTOR) {
      return new TupleCtorImpl(node);
    }
    else if (type == TYPE_DEF) {
      return new TypeDefImpl(node);
    }
    else if (type == TYPE_DESC) {
      return new TypeDescImpl(node);
    }
    else if (type == TYPE_SECT) {
      return new TypeSectImpl(node);
    }
    else if (type == VAR_DEF) {
      return new VarDefImpl(node);
    }
    else if (type == VAR_SECT) {
      return new VarSectImpl(node);
    }
    else if (type == VAR_TYPE_EXPR) {
      return new VarTypeExprImpl(node);
    }
    else if (type == WHEN_EXPR) {
      return new WhenExprImpl(node);
    }
    else if (type == WHEN_STMT) {
      return new WhenStmtImpl(node);
    }
    else if (type == WHILE_STMT) {
      return new WhileStmtImpl(node);
    }
    else if (type == YIELD_STMT) {
      return new YieldStmtImpl(node);
    }
    throw new AssertionError("Unknown element type: " + type);
  }

  public static ASTNode createIdentNode(Project project, String identifier) {
    NimFile file = createFile(project, identifier);
    List<Statement> statements = file.getStatements();
    if (statements.size() == 1) {
      Statement statement = statements.get(0);
      if (statement instanceof ExprStmt) {
        Expression expression = ((ExprStmt) statement).getExpression();
        if (expression instanceof IdentifierExpr) {
          return ((IdentifierExpr) expression).getIdentifier().getNode().findChildByType(IDENT);
        }
      }
    }
    throw new IncorrectOperationException("Invalid identifier");
  }

  private static NimFile createFile(Project project, String source) {
    return (NimFile) PsiFileFactory.getInstance(project).createFileFromText(NimLanguage.INSTANCE, source);
  }
}
