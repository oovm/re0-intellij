// This is a generated file. Not intended for manual editing.
package restart.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartDeclareItem extends PsiElement {

  @NotNull
  List<RestartDeclareBlock> getDeclareBlockList();

  @NotNull
  RestartDeclareKey getDeclareKey();

  @NotNull
  List<RestartExpression> getExpressionList();

  @NotNull
  List<RestartIfStatement> getIfStatementList();

}