// This is a generated file. Not intended for manual editing.
package restart.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static restart.language.psi.RestartTypes.*;
import restart.language.ast.RestartASTBase;
import restart.language.psi.*;
import restart.language.ast.ASTMethods;

public class RestartBlockNode extends RestartASTBase implements RestartBlock {

  public RestartBlockNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RestartVisitor visitor) {
    visitor.visitBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RestartVisitor) accept((RestartVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RestartExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RestartExpression.class);
  }

  @Override
  @NotNull
  public List<RestartForStatement> getForStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RestartForStatement.class);
  }

  @Override
  @NotNull
  public List<RestartIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RestartIfStatement.class);
  }

  @Override
  @NotNull
  public List<RestartWhileStatement> getWhileStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RestartWhileStatement.class);
  }

}