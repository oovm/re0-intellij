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

public class RestartForStatementNode extends RestartASTBase implements RestartForStatement {

  public RestartForStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RestartVisitor visitor) {
    visitor.visitForStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RestartVisitor) accept((RestartVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RestartBlock getBlock() {
    return findNotNullChildByClass(RestartBlock.class);
  }

  @Override
  @Nullable
  public RestartCasePattern getCasePattern() {
    return findChildByClass(RestartCasePattern.class);
  }

  @Override
  @Nullable
  public RestartElseStatement getElseStatement() {
    return findChildByClass(RestartElseStatement.class);
  }

  @Override
  @NotNull
  public RestartExpression getExpression() {
    return findNotNullChildByClass(RestartExpression.class);
  }

  @Override
  @Nullable
  public RestartIfGuard getIfGuard() {
    return findChildByClass(RestartIfGuard.class);
  }

  @Override
  @Nullable
  public RestartNormalPattern getNormalPattern() {
    return findChildByClass(RestartNormalPattern.class);
  }

}
