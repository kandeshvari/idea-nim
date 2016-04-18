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

  private boolean process(PsiNamedElement namedTarget) {
    if (symbolMatches(namedTarget.getName())) {
      this.target = namedTarget;
      return true;
    }
    return false;
  }

  @Override
  protected boolean processConst(ConstDef constDef) {
    return !process(constDef);
  }

  @Override
  protected boolean processEnumMember(EnumMember enumMember) {
    return !process(enumMember);
  }

  @Override
  protected boolean processParam(IdentifierDef param) {
    return !process(param);
  }

  @Override
  protected boolean processRoutine(RoutineDef routine) {
    return !process(routine);
  }

  @Override
  protected boolean processRoutineResult(ProcResultPsiElement result) {
    return !process(result);
  }

  @Override
  protected boolean processTypeDef(TypeDef typeDef) {
    return !process(typeDef);
  }

  @Override
  protected boolean processTypeParam(IdentifierDef typeParam) {
    return !process(typeParam);
  }

  @Override
  protected boolean processVar(IdentifierDef var) {
    return !process(var);
  }

  @Override
  protected boolean processField(IdentifierDef field) {
    return !process(field);
  }

  public PsiElement getResolvedTarget() {
    return target;
  }
}
