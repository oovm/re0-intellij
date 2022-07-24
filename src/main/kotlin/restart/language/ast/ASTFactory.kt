package restart.language.ast

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import restart.ide.file.RestartFileNode
import restart.ide.file.RestartFileType
import restart.language.psi.RestartIdentifier
import restart.language.psi_node.RestartIdentifierNode
import restart.language.psi_node.RestartPropertyStatementNode

class ASTFactory(val project: Project?) {
    fun createFile(text: CharSequence): RestartFileNode {
        val name = "dummy.simple"
        return PsiFileFactory.getInstance(project).createFileFromText(name, RestartFileType, text) as RestartFileNode
    }

    fun replaceID(target: RestartIdentifier, name: String): RestartIdentifierNode {
        val node =  createFile("属性 $name {}").firstChild as RestartPropertyStatementNode;
        return target.replace(node.identifier) as RestartIdentifierNode
    }
}