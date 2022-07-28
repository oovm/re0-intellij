package restart.language.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import restart.language.psi_node.RestartDeclareItemNode;
import restart.language.psi_node.RestartIdentifierNode;

public interface RestartDeclareStatement extends PsiElement {
    @NotNull
    RestartIdentifierNode getDeclareKeyword();

    @NotNull
    RestartDeclareKey getDeclareKey();

    @NotNull
    RestartIdentifierNode[] getModifiers();

    @NotNull
    RestartDeclareBlock getDeclareBlock();

    @NotNull
    RestartDeclareItemNode[] getDeclareItemList();

    @NotNull
    getEnumerationVariant()
}