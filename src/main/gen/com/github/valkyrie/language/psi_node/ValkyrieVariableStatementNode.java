// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.mixin.MixinProperty;
import com.github.valkyrie.language.psi.*;

public class ValkyrieVariableStatementNode extends MixinProperty implements ValkyrieVariableStatement {

  public ValkyrieVariableStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitVariableStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieBraceBlock getBraceBlock() {
    return findNotNullChildByClass(ValkyrieBraceBlock.class);
  }

  @Override
  @NotNull
  public ValkyrieIdentifier getIdentifier() {
    return findNotNullChildByClass(ValkyrieIdentifier.class);
  }

  @Override
  @NotNull
  public ValkyrieKwVariable getKwVariable() {
    return findNotNullChildByClass(ValkyrieKwVariable.class);
  }

  @Override
  @Nullable
  public ValkyrieModifiers getModifiers() {
    return findChildByClass(ValkyrieModifiers.class);
  }

}
