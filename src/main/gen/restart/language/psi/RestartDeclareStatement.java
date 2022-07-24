// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartDeclareStatement extends PsiElement {

  @NotNull
  RestartBraceBlock getBraceBlock();

  @NotNull
  RestartIdentifier getIdentifier();

  @NotNull
  RestartKwDeclare getKwDeclare();

  @Nullable
  RestartModifiers getModifiers();

}
