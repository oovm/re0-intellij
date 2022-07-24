// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.ast.RestartASTBase;
import com.github.valkyrie.language.psi.*;

public class ValkyrieConditionNode extends RestartASTBase implements ValkyrieCondition {

  public ValkyrieConditionNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitCondition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieCasePattern getCasePattern() {
    return findChildByClass(ValkyrieCasePattern.class);
  }

  @Override
  @NotNull
  public ValkyrieExpression getExpression() {
    return findNotNullChildByClass(ValkyrieExpression.class);
  }

}
