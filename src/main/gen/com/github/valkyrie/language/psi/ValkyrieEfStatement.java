// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieEfStatement extends PsiElement {

  @NotNull
  ValkyrieBraceBlock getBraceBlock();

  @NotNull
  ValkyrieCondition getCondition();

  @NotNull
  ValkyrieKwElseIf getKwElseIf();

}