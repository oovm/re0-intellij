// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartPatternValue extends PsiElement {

  @Nullable
  RestartBraceBlock getBraceBlock();

  @Nullable
  RestartIdentifier getIdentifier();

  @NotNull
  List<RestartPatternPair> getPatternPairList();

}
