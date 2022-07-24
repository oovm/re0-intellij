// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.ast.ValkyrieASTBase;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieTraitBlockNode extends ValkyrieASTBase implements ValkyrieTraitBlock {

  public ValkyrieTraitBlockNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitTraitBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieAwardStatement> getAwardStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieAwardStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieDeclareStatement> getDeclareStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieEventStatement> getEventStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieEventStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieHeroStatement> getHeroStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieHeroStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieVariableStatement> getVariableStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieVariableStatement.class);
  }

}
