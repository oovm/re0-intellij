// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartBlock extends PsiElement {

  @NotNull
  List<RestartExpression> getExpressionList();

  @NotNull
  List<RestartForStatement> getForStatementList();

  @NotNull
  List<RestartIfStatement> getIfStatementList();

  @NotNull
  List<RestartWhileStatement> getWhileStatementList();

}
