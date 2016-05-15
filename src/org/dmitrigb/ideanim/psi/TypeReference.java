package org.dmitrigb.ideanim.psi;

import java.util.stream.Collectors;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import org.dmitrigb.ideanim.psi.elements.GenericParam;
import org.dmitrigb.ideanim.psi.elements.Identifier;
import org.dmitrigb.ideanim.psi.elements.TypeDef;
import org.dmitrigb.ideanim.psi.stubs.indices.TypeIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeReference extends IdentifierReference {
  public TypeReference(@NotNull Identifier element) {
    super(element);
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    SymbolResolver resolver = SymbolResolver.forName(getElement().getText())
        .withFilter(elem -> elem instanceof TypeDef || elem instanceof GenericParam);
    NimPsiTreeUtil.walkUp(resolver, getElement(), () -> {
      Project project = getElement().getProject();
      return TypeIndex.getInstance().get(getElement().getText(), project, ImportProcessor.buildImportScope(getElement()));
    });
    return resolver.getResolvedTarget();
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    SymbolCollector collector = SymbolCollector.withFilter(el -> el instanceof TypeDef || el instanceof GenericParam);
    NimPsiTreeUtil.walkUp(collector, getElement(), () -> {
      Project project = getElement().getProject();
      TypeIndex typeIndex = TypeIndex.getInstance();
      GlobalSearchScope scope = ImportProcessor.buildImportScope(getElement());
      return typeIndex.getAllKeys(project).stream()
          .flatMap(key -> typeIndex.get(key, project, scope).stream())
          .collect(Collectors.toList());
    });
    return collector.getLookupElements().toArray();
  }
}
