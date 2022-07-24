package restart.ide.actions

import restart.ide.file.RestartIconProvider.Companion.FILE
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.Builder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class RestartCreateFile :
    CreateFileFromTemplateAction(name, description, FILE) {
    companion object {
        private val name = restart.RestartBundle.message("action.create_file")
        private val description = restart.RestartBundle.message("action.create_file.description")
        // See [resources/colors/fileTemplate]
        private const val templatePath = "Restart File";
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder.setTitle(name).addKind("Empty file", FILE, templatePath)
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
