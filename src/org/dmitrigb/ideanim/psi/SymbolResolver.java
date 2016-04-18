package org.dmitrigb.ideanim.psi;

import java.util.function.Predicate;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.ResolveState;
import org.dmitrigb.ideanim.NimIdentifierUtil;
import org.dmitrigb.ideanim.psi.elements.*;
import org.jetbrains.annotations.NotNull;

public class SymbolResolver extends SymbolProcessor {

  private final String symbolName;

  private final Predicate<PsiElement> elementFilter;

  private PsiElement target;

  public static SymbolResolver forName(String symbolName) {
    return new SymbolResolver(symbolName, null);
  }

  public SymbolResolver withFilter(Predicate<PsiElement> filter) {
    return new SymbolResolver(symbolName, filter);
  }

  protected SymbolResolver(String symbolName, Predicate<PsiElement> elementFilter) {
    this.elementFilter = elementFilter;
    this.symbolName = NimIdentifierUtil.normalizeId(symbolName);
  }

  protected boolean symbolMatches(String symbolText) {
    return NimIdentifierUtil.normalizeId(symbolText).equals(symbolName);
  }

  @Override
  public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
    if (elementFilter == null || elementFilter.test(element))
      return super.execute(element, state);
    return true;
  }

  private boolean match(IdentifierDef idDef) {
    return match(idDef, idDef);
  }

  private boolean match(Identifier id, PsiNamedElement target) {
    return match(id.getText(), target);
  }

  private boolean match(String name, PsiNamedElement target) {
    if (symbolMatches(name)) {
      this.target = target;
      return true;
    }
    return false;
  }

  @Override
  protected boolean processConst(ConstDef constDef) {
    return !match(constDef.getIdentifier(), constDef);
  }

  @Override
  protected boolean processEnumMember(EnumMember enumMember) {
    return !match(enumMember.getIdentifier(), enumMember);
  }

  @Override
  protected boolean processParam(IdentifierDef param) {
    return !match(param);
  }

  @Override
  protected boolean processRoutine(RoutineDef routine) {
    return !match(routine.getIdentifier(), routine);
  }

  @Override
  protected boolean processRoutineResult(ProcResultPsiElement result) {
    return !symbolMatches("result");
  }

  @Override
  protected boolean processTypeDef(TypeDef typeDef) {
    return !match(typeDef.getName(), typeDef);
  }

  @Override
  protected boolean processTypeParam(IdentifierDef typeParam) {
    return !match(typeParam);
  }

  @Override
  protected boolean processVar(IdentifierDef var) {
    return !match(var);
  }

  @Override
  protected boolean processField(IdentifierDef field) {
    return !match(field);
  }

  public PsiElement getResolvedTarget() {
    return target;
  }
}
