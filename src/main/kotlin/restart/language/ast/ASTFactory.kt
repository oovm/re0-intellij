package restart.language.ast

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import restart.ide.file.RestartFileNode
import restart.ide.file.RestartFileType

object ASTFactory {
    fun createFile(project: Project?, text: CharSequence): RestartFileNode {
        val name = "dummy.simple"
        return PsiFileFactory.getInstance(project).createFileFromText(name, RestartFileType, text) as RestartFileNode
    }
}