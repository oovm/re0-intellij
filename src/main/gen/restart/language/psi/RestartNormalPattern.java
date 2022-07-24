// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartNormalPattern extends PsiElement {

  @Nullable
  RestartDeclareItem getDeclareItem();

  @NotNull
  List<RestartIdentifier> getIdentifierList();

  @NotNull
  List<RestartPatternItem> getPatternItemList();

}
