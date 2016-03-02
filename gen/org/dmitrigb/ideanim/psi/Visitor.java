// This is a generated file. Not intended for manual editing.
package org.dmitrigb.ideanim.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class Visitor extends PsiElementVisitor {

  public void visitAssignmentExpr(@NotNull AssignmentExpr o) {
    visitExpression(o);
  }

  public void visitBlockStmt(@NotNull BlockStmt o) {
    visitStatement(o);
  }

  public void visitBracketCtor(@NotNull BracketCtor o) {
    visitExpression(o);
  }

  public void visitBracketExpr(@NotNull BracketExpr o) {
    visitExpression(o);
  }

  public void visitBreakStmt(@NotNull BreakStmt o) {
    visitStatement(o);
  }

  public void visitCallExpr(@NotNull CallExpr o) {
    visitExpression(o);
  }

  public void visitCaseExpr(@NotNull CaseExpr o) {
    visitExpression(o);
  }

  public void visitCaseStmt(@NotNull CaseStmt o) {
    visitStatement(o);
  }

  public void visitCastExpr(@NotNull CastExpr o) {
    visitExpression(o);
  }

  public void visitCommandExpr(@NotNull CommandExpr o) {
    visitExpression(o);
  }

  public void visitConstDef(@NotNull ConstDef o) {
    visitPsiElement(o);
  }

  public void visitConstSect(@NotNull ConstSect o) {
    visitStatement(o);
  }

  public void visitDiscardStmt(@NotNull DiscardStmt o) {
    visitStatement(o);
  }

  public void visitDoBlock(@NotNull DoBlock o) {
    visitPsiElement(o);
  }

  public void visitDotExpr(@NotNull DotExpr o) {
    visitExpression(o);
  }

  public void visitEnumDef(@NotNull EnumDef o) {
    visitPsiElement(o);
  }

  public void visitExprStmt(@NotNull ExprStmt o) {
    visitStatement(o);
  }

  public void visitExpression(@NotNull Expression o) {
    visitPsiElement(o);
  }

  public void visitForStmt(@NotNull ForStmt o) {
    visitStatement(o);
  }

  public void visitGenericParamList(@NotNull GenericParamList o) {
    visitPsiElement(o);
  }

  public void visitGroupedExpr(@NotNull GroupedExpr o) {
    visitExpression(o);
  }

  public void visitIdentifier(@NotNull Identifier o) {
    visitExpression(o);
  }

  public void visitIfExpr(@NotNull IfExpr o) {
    visitExpression(o);
  }

  public void visitIfStmt(@NotNull IfStmt o) {
    visitStatement(o);
  }

  public void visitImportStmt(@NotNull ImportStmt o) {
    visitStatement(o);
  }

  public void visitInfixExpr(@NotNull InfixExpr o) {
    visitExpression(o);
  }

  public void visitIteratorDef(@NotNull IteratorDef o) {
    visitRoutineDef(o);
  }

  public void visitLetSect(@NotNull LetSect o) {
    visitStatement(o);
  }

  public void visitLiteral(@NotNull Literal o) {
    visitExpression(o);
  }

  public void visitNilToken(@NotNull NilToken o) {
    visitExpression(o);
  }

  public void visitObjectDef(@NotNull ObjectDef o) {
    visitPsiElement(o);
  }

  public void visitParamList(@NotNull ParamList o) {
    visitPsiElement(o);
  }

  public void visitPattern(@NotNull Pattern o) {
    visitPsiElement(o);
  }

  public void visitPragma(@NotNull Pragma o) {
    visitPsiElement(o);
  }

  public void visitPragmaStmt(@NotNull PragmaStmt o) {
    visitStatement(o);
  }

  public void visitPrefixExpr(@NotNull PrefixExpr o) {
    visitExpression(o);
  }

  public void visitProcDef(@NotNull ProcDef o) {
    visitRoutineDef(o);
  }

  public void visitRaiseStmt(@NotNull RaiseStmt o) {
    visitStatement(o);
  }

  public void visitReturnStmt(@NotNull ReturnStmt o) {
    visitStatement(o);
  }

  public void visitRoutineBody(@NotNull RoutineBody o) {
    visitPsiElement(o);
  }

  public void visitRoutineDef(@NotNull RoutineDef o) {
    visitStatement(o);
  }

  public void visitSetOrTableCtor(@NotNull SetOrTableCtor o) {
    visitExpression(o);
  }

  public void visitStatement(@NotNull Statement o) {
    visitPsiElement(o);
  }

  public void visitSymbol(@NotNull Symbol o) {
    visitPsiElement(o);
  }

  public void visitTemplateDef(@NotNull TemplateDef o) {
    visitRoutineDef(o);
  }

  public void visitTryStmt(@NotNull TryStmt o) {
    visitPsiElement(o);
  }

  public void visitTypeDef(@NotNull TypeDef o) {
    visitPsiElement(o);
  }

  public void visitTypeDesc(@NotNull TypeDesc o) {
    visitPsiElement(o);
  }

  public void visitTypeSect(@NotNull TypeSect o) {
    visitStatement(o);
  }

  public void visitVarDef(@NotNull VarDef o) {
    visitPsiElement(o);
  }

  public void visitVarSect(@NotNull VarSect o) {
    visitStatement(o);
  }

  public void visitWhenExpr(@NotNull WhenExpr o) {
    visitExpression(o);
  }

  public void visitWhenStmt(@NotNull WhenStmt o) {
    visitStatement(o);
  }

  public void visitWhileStmt(@NotNull WhileStmt o) {
    visitStatement(o);
  }

  public void visitYieldStmt(@NotNull YieldStmt o) {
    visitStatement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
