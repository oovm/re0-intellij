package restart.ide.goto

import com.intellij.codeInsight.navigation.GotoTargetHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

class VGotoSuperHandler : GotoTargetHandler() {
    override fun getFeatureUsedKey(): String {
        TODO("Not yet implemented")
    }

    override fun getSourceAndTargetElements(editor: Editor?, file: PsiFile?): GotoData? {
        TODO("Not yet implemented")
    }

    override fun getNotFoundMessage(project: Project, editor: Editor, file: PsiFile): String {
        TODO("Not yet implemented")
    }

}

