// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.ast.RestartASTBase;
import com.github.valkyrie.language.psi.*;

public class ValkyrieForStatementNode extends RestartASTBase implements ValkyrieForStatement {

  public ValkyrieForStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitForStatement(this);
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
  @Nullable
  public ValkyrieCasePattern getCasePattern() {
    return findChildByClass(ValkyrieCasePattern.class);
  }

  @Override
  @Nullable
  public ValkyrieElseStatement getElseStatement() {
    return findChildByClass(ValkyrieElseStatement.class);
  }

  @Override
  @NotNull
  public ValkyrieExpression getExpression() {
    return findNotNullChildByClass(ValkyrieExpression.class);
  }

  @Override
  @Nullable
  public ValkyrieIfGuard getIfGuard() {
    return findChildByClass(ValkyrieIfGuard.class);
  }

  @Override
  @Nullable
  public ValkyrieNormalPattern getNormalPattern() {
    return findChildByClass(ValkyrieNormalPattern.class);
  }

}
