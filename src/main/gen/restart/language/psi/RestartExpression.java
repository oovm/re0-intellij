// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartExpression extends PsiElement {

  @NotNull
  List<RestartBoolean> getBooleanList();

  @NotNull
  List<RestartCallSuffix> getCallSuffixList();

  @NotNull
  List<RestartList> getListList();

  @NotNull
  List<RestartNamepath> getNamepathList();

  @NotNull
  List<RestartNumber> getNumberList();

  @NotNull
  List<RestartRange> getRangeList();

  @NotNull
  List<RestartSlice> getSliceList();

  @NotNull
  List<RestartString> getStringList();

  @NotNull
  List<RestartTuple> getTupleList();

}
