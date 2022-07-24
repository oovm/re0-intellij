// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.ast.RestartASTBase;
import com.github.valkyrie.language.psi.*;

public class ValkyrieNewStatementNode extends RestartASTBase implements ValkyrieNewStatement {

  public ValkyrieNewStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitNewStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieModifiers getModifiers() {
    return findNotNullChildByClass(ValkyrieModifiers.class);
  }

  @Override
  @NotNull
  public ValkyrieTraitBlock getTraitBlock() {
    return findNotNullChildByClass(ValkyrieTraitBlock.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeExpression getTypeExpression() {
    return findChildByClass(ValkyrieTypeExpression.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeGeneric getTypeGeneric() {
    return findChildByClass(ValkyrieTypeGeneric.class);
  }

}
