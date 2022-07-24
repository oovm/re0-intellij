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

public class RestartDeclareItemNode extends RestartASTBase implements RestartDeclareItem {

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
  @Nullable
  public RestartBoolean getBoolean() {
    return findChildByClass(RestartBoolean.class);
  }

  @Override
  @Nullable
  public RestartBracketFree getBracketFree() {
    return findChildByClass(RestartBracketFree.class);
  }

  @Override
  @NotNull
  public List<RestartDeclareItem> getDeclareItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RestartDeclareItem.class);
  }

  @Override
  @NotNull
  public RestartDeclareKey getDeclareKey() {
    return findNotNullChildByClass(RestartDeclareKey.class);
  }

  @Override
  @Nullable
  public RestartForStatement getForStatement() {
    return findChildByClass(RestartForStatement.class);
  }

  @Override
  @Nullable
  public RestartIfStatement getIfStatement() {
    return findChildByClass(RestartIfStatement.class);
  }

  @Override
  @Nullable
  public RestartNamepath getNamepath() {
    return findChildByClass(RestartNamepath.class);
  }

  @Override
  @Nullable
  public RestartNumber getNumber() {
    return findChildByClass(RestartNumber.class);
  }

  @Override
  @Nullable
  public RestartString getString() {
    return findChildByClass(RestartString.class);
  }

  @Override
  @Nullable
  public RestartWhileStatement getWhileStatement() {
    return findChildByClass(RestartWhileStatement.class);
  }

}
