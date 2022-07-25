// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartDeclareItem extends PsiElement {

  @Nullable
  RestartBracketFree getBracketFree();

  @Nullable
  RestartDeclareBlock getDeclareBlock();

  @NotNull
  RestartDeclareKey getDeclareKey();

  @Nullable
  RestartExpression getExpression();

  @Nullable
  RestartIfStatement getIfStatement();

}
