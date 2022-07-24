// This is a generated file. Not intended for manual editing.
package restart.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static restart.language.psi.RestartTypes.*;
import restart.language.mixin.MixinNormalPattern;
import restart.language.psi.*;
import restart.language.ast.ASTMethods;

public class RestartNormalPatternNode extends MixinNormalPattern implements RestartNormalPattern {

  public RestartNormalPatternNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RestartVisitor visitor) {
    visitor.visitNormalPattern(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RestartVisitor) accept((RestartVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RestartDeclareItem getDeclareItem() {
    return findChildByClass(RestartDeclareItem.class);
  }

  @Override
  @NotNull
  public List<RestartIdentifier> getIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RestartIdentifier.class);
  }

  @Override
  @NotNull
  public List<RestartPatternItem> getPatternItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RestartPatternItem.class);
  }

}
