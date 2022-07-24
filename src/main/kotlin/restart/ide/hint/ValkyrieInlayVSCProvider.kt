package restart.ide.hint

import restart.language.psi.RestartAwardStatement
import restart.language.psi.RestartDeclareStatement
import restart.language.psi.RestartEventStatement
import restart.language.psi.RestartHeroStatement
import restart.language.psi.RestartVariableStatement
import restart.language.psi_node.*
import com.intellij.codeInsight.hints.VcsCodeVisionLanguageContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import java.awt.event.MouseEvent

@Suppress("UnstableApiUsage")
class RestartInlayVSCProvider : VcsCodeVisionLanguageContext {
    /// 额外的点击事件
    /// 本身会打开 Git Blame
    override fun handleClick(mouseEvent: MouseEvent, editor: Editor, element: PsiElement) {

    }

    override fun isAccepted(element: PsiElement): Boolean = when (element) {
        is RestartVariableStatement,
        is RestartEventStatement,
        is RestartAwardStatement,
        is RestartHeroStatement,
        is RestartDeclareStatement,
        -> true

        else -> false
    }
}

