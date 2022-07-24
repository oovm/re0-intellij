package restart.ide.hint

import restart.language.psi.ValkyrieAwardStatement
import restart.language.psi.ValkyrieDeclareStatement
import restart.language.psi.ValkyrieEventStatement
import restart.language.psi.ValkyrieHeroStatement
import restart.language.psi.ValkyrieVariableStatement
import restart.language.psi_node.*
import com.intellij.codeInsight.hints.VcsCodeVisionLanguageContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import java.awt.event.MouseEvent

@Suppress("UnstableApiUsage")
class ValkyrieInlayVSCProvider : VcsCodeVisionLanguageContext {
    /// 额外的点击事件
    /// 本身会打开 Git Blame
    override fun handleClick(mouseEvent: MouseEvent, editor: Editor, element: PsiElement) {

    }

    override fun isAccepted(element: PsiElement): Boolean = when (element) {
        is ValkyrieVariableStatement,
        is ValkyrieEventStatement,
        is ValkyrieAwardStatement,
        is ValkyrieHeroStatement,
        is ValkyrieDeclareStatement,
        -> true

        else -> false
    }
}

