// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartIfStatement extends PsiElement {

  @NotNull
  RestartBraceBlock getBraceBlock();

  @NotNull
  RestartCondition getCondition();

  @NotNull
  List<RestartEfStatement> getEfStatementList();

  @Nullable
  RestartElseStatement getElseStatement();

}
