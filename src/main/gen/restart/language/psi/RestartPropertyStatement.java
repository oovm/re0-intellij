// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartPropertyStatement extends PsiElement {

  @NotNull
  RestartDeclareBlock getDeclareBlock();

  @NotNull
  RestartIdentifier getIdentifier();

  @NotNull
  RestartKwProperty getKwProperty();

  @Nullable
  RestartModifiers getModifiers();

}