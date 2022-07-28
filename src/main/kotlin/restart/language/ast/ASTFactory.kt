package restart.language.ast

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import restart.ide.file.RestartFileNode
import restart.ide.file.RestartFileType
import restart.language.psi.RestartDeclareKey
import restart.language.psi_node.RestartDeclareKeyNode
import restart.language.psi_node.RestartDeclareStatementNode


class ASTFactory {
    val project: Project?

    constructor(project: Project?) {
        this.project = project
    }
    constructor(element: PsiElement?) {
        this.project = element?.project
    }

    fun createFile(text: CharSequence): RestartFileNode {
        val name = "dummy.re0"
        return PsiFileFactory.getInstance(project).createFileFromText(name, RestartFileType, text) as RestartFileNode
    }
    fun replaceKey(target: RestartDeclareKey, name: String): RestartDeclareKeyNode {
        val node =  createFile("属性 $name {}").firstChild as RestartDeclareStatementNode;
        return target.replace(node.getDeclareKey()) as RestartDeclareKeyNode
    }
}