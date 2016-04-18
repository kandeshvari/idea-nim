package org.dmitrigb.ideanim.psi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.NotNull;

public class SymbolCollector extends SymbolProcessor {

  private final Predicate<PsiElement> filter;

  private List<LookupElement> elements = new ArrayList<>();

  public static SymbolCollector withFilter(Predicate<PsiElement> filter) {
    return new SymbolCollector(filter);
  }

  protected SymbolCollector(Predicate<PsiElement> filter) {
    this.filter = filter;
  }

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (filter == null || filter.test(element))
      super.execute(element, state);
    return true;
  }

  @Override
  protected boolean processConst(ConstDef constDef) {
    return true;
  }

  @Override
  protected boolean processEnumMember(EnumMember enumMember) {
    return true;
  }

  @Override
  protected boolean processField(IdentifierDef field) {
    elements.add(LookupElementBuilder.create(field)
        .withTypeText(((ObjectFields) field.getContext()).getDeclaredType().getText())
        .withIcon(AllIcons.Nodes.Field));
    return true;
  }

  @Override
  protected boolean processParam(IdentifierDef param) {
    return true;
  }

  @Override
  protected boolean processRoutine(RoutineDef routine) {
    elements.add(LookupElementBuilder.create(routine)
        .withIcon(AllIcons.Nodes.Method)
        .withTailText("(" + routine.getParameters().stream().map(PsiElement::getText).collect(Collectors.joining(", ")) + ")")
        .withTypeText(routine.getReturnType() == null ? null : routine.getReturnType().getText())
        .withInsertHandler((context, item) -> {
          Editor editor = context.getEditor();
          Document document = editor.getDocument();
          int offset = context.getTailOffset();
          document.insertString(offset, "()");
          RoutineDef def = (RoutineDef) item.getPsiElement();
          assert def != null;
          editor.getCaretModel().moveToOffset(offset + (def.getParameterCount() == 1 ? 2 : 1));
        }));
    return true;
  }

  @Override
  protected boolean processRoutineResult(ProcResultPsiElement result) {
    return true;
  }

  @Override
  protected boolean processTypeDef(TypeDef typeDef) {
    elements.add(LookupElementBuilder.create(typeDef).withIcon(AllIcons.Nodes.Class));
    return true;
  }

  @Override
  protected boolean processTypeParam(IdentifierDef typeParam) {
    elements.add(LookupElementBuilder.create(typeParam));
    return true;
  }

  @Override
  protected boolean processVar(IdentifierDef var) {
    return true;
  }

  public List<LookupElement> getLookupElements() {
    return elements;
  }
}
