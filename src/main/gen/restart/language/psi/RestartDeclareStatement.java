// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartDeclareStatement extends PsiElement {

  @NotNull
  RestartDeclareBlock getDeclareBlock();

  @NotNull
  RestartDeclareKey getDeclareKey();

  @NotNull
  RestartKwDeclare getKwDeclare();

  @Nullable
  RestartModifiers getModifiers();

}
