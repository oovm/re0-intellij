package restart.ide.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentIterator
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import restart.ide.file.RestartFileNode
import restart.language.psi_node.RestartDeclareStatementNode
import restart.language.symbol.RestartSymbolKind

// TODO: cache
class IdentifierStorage(val project: Project?) : ContentIterator {
    var dict: MutableMap<String, IdentifierInfo> = mutableMapOf()
    override fun processFile(fileInProject: VirtualFile): Boolean {
        project ?: return false
        val file = PsiManager.getInstance(project).findFile(fileInProject) as? RestartFileNode
        analyzeFile(file)
        return true
    }

    private fun analyzeFile(file: RestartFileNode?) {
        file ?: return
        for (item in file.children) {
            if (item is RestartDeclareStatementNode) {
                analyzeDeclare(item)
            }
        }
    }

    private fun analyzeDeclare(node: RestartDeclareStatementNode) {
        dict[node.name] = IdentifierInfo(node.nameIdentifier, RestartSymbolKind.Property)
        node.aliases.forEach {
            dict[it.text] = IdentifierInfo(it, node.kind)
        }
        node.enumerationVariant.forEach {
            dict[it.text] = IdentifierInfo(it, RestartSymbolKind.Enumerate)
        }
    }


    companion object {

    }
}

