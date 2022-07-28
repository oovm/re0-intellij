// This is a generated file. Not intended for manual editing.
package restart.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartExpression extends PsiElement {

  @NotNull
  List<RestartBoolean> getBooleanList();

  @NotNull
  List<RestartCallSuffix> getCallSuffixList();

  @NotNull
  List<RestartIdentifier> getIdentifierList();

  @NotNull
  List<RestartNumber> getNumberList();

  @NotNull
  List<RestartString> getStringList();

}
