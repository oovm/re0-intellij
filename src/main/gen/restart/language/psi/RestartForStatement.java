// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartForStatement extends PsiElement {

  @NotNull
  RestartBlock getBlock();

  @Nullable
  RestartCasePattern getCasePattern();

  @Nullable
  RestartElseStatement getElseStatement();

  @NotNull
  RestartExpression getExpression();

  @Nullable
  RestartIfGuard getIfGuard();

  @Nullable
  RestartNormalPattern getNormalPattern();

}
