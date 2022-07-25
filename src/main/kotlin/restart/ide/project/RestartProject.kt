package restart.ide.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentIterator
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import restart.ide.file.RestartFileNode
import restart.ide.project.IdentifierStorage.IdentifierInfo
import restart.language.ast.RestartASTBase
import restart.language.psi_node.RestartIdentifierNode
import restart.language.psi_node.RestartPropertyStatementNode
import restart.language.symbol.RestartSymbolKind

class RestartProject() {
    companion object {
        fun getStorage(project: Project?): MutableMap<String, IdentifierInfo> {
            project ?: return mutableMapOf();
            val store = IdentifierStorage(project);
            ProjectFileIndex.getInstance(project).iterateContent {
                store.processFile(it)
            }
            return store.dict
        }
    }
}


// TODO: cache
class IdentifierStorage(val project: Project?) : ContentIterator {
    data class IdentifierInfo(val node: RestartIdentifierNode, val kind: RestartSymbolKind);

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
            when (item) {
                is RestartPropertyStatementNode -> analyzeDeclare(item)

            }
        }
    }

    private fun analyzeDeclare(node: RestartPropertyStatementNode) {
        dict[node.name] = IdentifierInfo(node, RestartSymbolKind.Property)
    }
}
