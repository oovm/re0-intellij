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

public class RestartEfStatementNode extends RestartASTBase implements RestartEfStatement {

  public RestartEfStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RestartVisitor visitor) {
    visitor.visitEfStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RestartVisitor) accept((RestartVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RestartBraceBlock getBraceBlock() {
    return findNotNullChildByClass(RestartBraceBlock.class);
  }

  @Override
  @NotNull
  public RestartCondition getCondition() {
    return findNotNullChildByClass(RestartCondition.class);
  }

  @Override
  @NotNull
  public RestartKwElseIf getKwElseIf() {
    return findNotNullChildByClass(RestartKwElseIf.class);
  }

}
