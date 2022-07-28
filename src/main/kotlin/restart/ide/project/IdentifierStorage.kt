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
        // dict[node.name] = IdentifierInfo(node.nameIdentifier, RestartSymbolKind.Property)
        for (item in node.declareBlock.declareItemList) {
            when (item.declareKey.text) {
                "别称", "alias" -> {
                    item.expressionList.forEach {
                        val out = IdentifierInfo.tryFrom(it, RestartSymbolKind.Property);
                        if (out != null) {
                            dict[it.text] = out
                        }
                    }
                }
                "枚举", "enum" -> {
                    item.expressionList.forEach {
                        val out = IdentifierInfo.tryFrom(it, RestartSymbolKind.Enumerate);
                        if (out != null) {
                            dict[it.text] = out
                        }
                    }
                }
            }
        }

    }


    companion object {

    }
}

