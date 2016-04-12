package org.dmitrigb.ideanim;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.dmitrigb.ideanim.parser.NimParser;
import org.dmitrigb.ideanim.psi.ElementFactory;
import org.dmitrigb.ideanim.psi.NimFile;
import org.dmitrigb.ideanim.psi.ElementTypes;
import org.jetbrains.annotations.NotNull;

public class NimParserDefinition implements ParserDefinition {

  public static final IFileElementType FILE = new IFileElementType(Language.findInstance(NimLanguage.class));

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new NimLexerAdapter();
  }

  @Override
  public PsiParser createParser(Project project) {
    return new NimParser();
  }

  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @NotNull
  @Override
  public TokenSet getWhitespaceTokens() {
    return TokenSet.create(TokenType.WHITE_SPACE);
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return TokenSet.create(ElementTypes.BLOCK_COMMENT, ElementTypes.LINE_COMMENT);
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return ElementTypes.STRINGS;
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode node) {
    return ElementFactory.createElement(node);
  }

  @Override
  public PsiFile createFile(FileViewProvider viewProvider) {
    return new NimFile(viewProvider);
  }

  @Override
  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
    return SpaceRequirements.MAY;
  }
}
