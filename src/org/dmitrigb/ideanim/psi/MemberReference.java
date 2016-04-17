package org.dmitrigb.ideanim.psi;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.dmitrigb.ideanim.psi.elements.Expression;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.ObjectDef;
import org.dmitrigb.ideanim.psi.elements.ObjectFields;
import org.dmitrigb.ideanim.psi.elements.RoutineDef;
import org.dmitrigb.ideanim.types.TObject;
import org.dmitrigb.ideanim.types.Type;
import org.dmitrigb.ideanim.types.Types;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MemberReference extends IdentifierReference {

  private Expression expression;
  private List<Expression> callArgs;
  private final boolean fieldsOnly;

  /**
   * A reference to a member of an object.
   * Using this constructor will create a reference that only resolves to fields, and not to procedures.
   * This is useful when resolving field references inside an object constructor.
   */
  public MemberReference(@NotNull Expression expression, @NotNull Identifier identifier) {
    super(identifier);
    this.expression = expression;
    fieldsOnly = true;
  }

  /**
   * A reference to a member of an object.
   * Using this constructor will create a reference that resolves to both - fields as well as procedures.
   */
  public MemberReference(@NotNull Expression expression, @NotNull Identifier identifier, @Nullable List<Expression> callArgs) {
    super(identifier);
    this.expression = expression;
    this.callArgs = callArgs;
    fieldsOnly = false;
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    MemberResolver memberResolver = new MemberResolver(getElement());
    if (!walkUpHierarchy(memberResolver, expression.getType()))
      return memberResolver.getResolvedTarget();

    // No matching field found, try to resolve to a proc
    if (!fieldsOnly) {
      List<Expression> args = new ArrayList<>();
      args.add(expression);
      if (callArgs != null)
        args.addAll(callArgs);
      RoutineResolver resolver = new RoutineResolver(getElement(), args);
      NimPsiTreeUtil.walkUp(resolver, getElement(), null, getElement().getText());
      return resolver.getResolvedTarget();
    }

    return null;
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    List<LookupElement> results = new ArrayList<>();

    MemberCollector memberCollector = new MemberCollector();
    Type type = expression.getType();
    walkUpHierarchy(memberCollector, type);
    results.addAll(memberCollector.getCandidates().stream()
        .map(el -> LookupElementBuilder.create(el)
            .withTypeText(((ObjectFields) el.getContext()).getDeclaredType().getText())
            .withIcon(AllIcons.Nodes.Field))
        .collect(Collectors.toList()));

    if (!fieldsOnly) {
      RoutineCollector routineCollector = new RoutineCollector(expression);
      PsiElement def = Types.resolveDefinition(type);
      // TODO: take files of all objects in the hierarchy
      PsiFile file = def == null ? null : def.getContainingFile();
      NimPsiTreeUtil.walkUpWithFiles(routineCollector, getElement(), null, file == null ? new PsiFile[0] : new PsiFile[]{file});
      results.addAll(routineCollector.getCandidates().stream()
          .map(el -> LookupElementBuilder.create(el)
              .withIcon(AllIcons.Nodes.Method)
              .withTailText("(" + el.getParameters().stream().map(PsiElement::getText).collect(Collectors.joining(", ")) + ")")
              .withTypeText(el.getReturnType() == null ? null : el.getReturnType().getText())
              .withInsertHandler((context, item) -> {
                Editor editor = context.getEditor();
                Document document = editor.getDocument();
                int offset = context.getTailOffset();
                document.insertString(offset, "()");
                RoutineDef routine = (RoutineDef) item.getPsiElement();
                assert routine != null;
                editor.getCaretModel().moveToOffset(offset + (routine.getParameterCount() == 1 ? 2 : 1));
              }))
          .collect(Collectors.toList()));
    }

    return results.toArray();
  }

  private boolean walkUpHierarchy(PsiScopeProcessor processor, Type type) {
    ResolveState state = ResolveState.initial();
    type = Types.unwrapNamedAndDeref(type);
    while (type instanceof TObject) {
      TObject tObj = (TObject) type;
      if (!tObj.getObject().processDeclarations(processor, state, null, getElement()))
        return false;
      type = Types.unwrapNamedAndDeref(tObj.getSuperType());
    }
    return true;
  }
}
