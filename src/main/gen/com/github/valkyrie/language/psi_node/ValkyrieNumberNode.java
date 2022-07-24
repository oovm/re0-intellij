// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.mixin.MixinNumber;
import com.github.valkyrie.language.psi.*;

public class ValkyrieNumberNode extends MixinNumber implements ValkyrieNumber {

  public ValkyrieNumberNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitNumber(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieIdentifier getIdentifier() {
    return findChildByClass(ValkyrieIdentifier.class);
  }

}
