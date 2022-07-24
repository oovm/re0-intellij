// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTraitBlock extends PsiElement {

  @NotNull
  List<ValkyrieAwardStatement> getAwardStatementList();

  @NotNull
  List<ValkyrieDeclareStatement> getDeclareStatementList();

  @NotNull
  List<ValkyrieEventStatement> getEventStatementList();

  @NotNull
  List<ValkyrieHeroStatement> getHeroStatementList();

  @NotNull
  List<ValkyrieVariableStatement> getVariableStatementList();

}
