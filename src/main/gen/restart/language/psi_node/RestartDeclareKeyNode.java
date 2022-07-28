// This is a generated file. Not intended for manual editing.
package restart.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static restart.language.psi.RestartTypes.*;
import restart.language.mixin.MixinKey;
import restart.language.ast.ASTMethods;

public class RestartDeclareKeyNode extends MixinKey implements RestartDeclareKey {

  public RestartDeclareKeyNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RestartVisitor visitor) {
    visitor.visitDeclareKey(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RestartVisitor) accept((RestartVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RestartIdentifier getIdentifier() {
    return findChildByClass(RestartIdentifier.class);
  }

  @Override
  @Nullable
  public RestartNumber getNumber() {
    return findChildByClass(RestartNumber.class);
  }

}
