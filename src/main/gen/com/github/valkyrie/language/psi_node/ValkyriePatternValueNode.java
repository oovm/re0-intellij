// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.github.valkyrie.language.ast.RestartASTBase;
import com.github.valkyrie.language.psi.*;

public class ValkyriePatternValueNode extends RestartASTBase implements ValkyriePatternValue {

  public ValkyriePatternValueNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitPatternValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieBraceBlock getBraceBlock() {
    return findChildByClass(ValkyrieBraceBlock.class);
  }

  @Override
  @Nullable
  public ValkyrieIdentifier getIdentifier() {
    return findChildByClass(ValkyrieIdentifier.class);
  }

  @Override
  @NotNull
  public List<ValkyriePatternPair> getPatternPairList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyriePatternPair.class);
  }

}
