package restart.ide.actions

import com.intellij.ide.actions.CreateFileAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import restart.RestartBundle
import restart.ide.file.RestartIconProvider.Companion.FILE

class FluentConvertMo : CreateFileAction(name, description, FILE) {
    companion object {
        private val name = RestartBundle.message("action.convert_prop")
        private val description = RestartBundle.message("action.convert_prop.description")

    }

    private var sourceFile: PsiFile? = null

    override fun update(event: AnActionEvent) {
        sourceFile = LangDataKeys.PSI_FILE.getData(event.dataContext)
        super.update(event)
    }

}
