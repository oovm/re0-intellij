// This is a generated file. Not intended for manual editing.
package restart.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RestartDeclareItem extends PsiElement {

  @Nullable
  RestartBoolean getBoolean();

  @Nullable
  RestartBracketFree getBracketFree();

  @NotNull
  List<RestartDeclareItem> getDeclareItemList();

  @NotNull
  RestartDeclareKey getDeclareKey();

  @Nullable
  RestartForStatement getForStatement();

  @Nullable
  RestartIfStatement getIfStatement();

  @Nullable
  RestartNamepath getNamepath();

  @Nullable
  RestartNumber getNumber();

  @Nullable
  RestartString getString();

  @Nullable
  RestartWhileStatement getWhileStatement();

}
