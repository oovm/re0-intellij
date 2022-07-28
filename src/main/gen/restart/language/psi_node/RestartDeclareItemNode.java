// This is a generated file. Not intended for manual editing.
package restart.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static restart.language.psi.RestartTypes.*;
import restart.language.mixin.MixinDeclareItem;
import restart.language.psi.*;
import restart.language.ast.ASTMethods;

public class RestartDeclareItemNode extends MixinDeclareItem implements RestartDeclareItem {

  public RestartDeclareItemNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RestartVisitor visitor) {
    visitor.visitDeclareItem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RestartVisitor) accept((RestartVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RestartDeclareBlock> getDeclareBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RestartDeclareBlock.class);
  }

  @Override
  @NotNull
  public RestartDeclareKey getDeclareKey() {
    return findNotNullChildByClass(RestartDeclareKey.class);
  }

  @Override
  @NotNull
  public List<RestartExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RestartExpression.class);
  }

  @Override
  @NotNull
  public List<RestartIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RestartIfStatement.class);
  }

}
