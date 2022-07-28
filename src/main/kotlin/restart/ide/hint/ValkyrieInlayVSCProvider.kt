package restart.ide.hint

import com.intellij.codeInsight.hints.VcsCodeVisionLanguageContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import restart.language.psi_node.RestartDeclareStatement
import java.awt.event.MouseEvent

@Suppress("UnstableApiUsage")
class RestartInlayVSCProvider : VcsCodeVisionLanguageContext {
    /// 额外的点击事件
    /// 本身会打开 Git Blame
    override fun handleClick(mouseEvent: MouseEvent, editor: Editor, element: PsiElement) {

    }

    override fun isAccepted(element: PsiElement): Boolean = when (element) {
        is RestartDeclareStatement -> true
        else -> false
    }
}

