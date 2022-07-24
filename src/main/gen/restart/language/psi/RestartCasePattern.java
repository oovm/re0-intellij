// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartCasePattern extends PsiElement {

  @NotNull
  RestartDeclareItem getDeclareItem();

  @NotNull
  List<RestartIdentifier> getIdentifierList();

  @Nullable
  RestartNamepath getNamepath();

}
