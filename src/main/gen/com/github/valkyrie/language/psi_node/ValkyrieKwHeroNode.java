// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.ast.RestartASTBase;
import com.github.valkyrie.language.psi.*;

public class ValkyrieKwHeroNode extends RestartASTBase implements ValkyrieKwHero {

  public ValkyrieKwHeroNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitKwHero(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

}
