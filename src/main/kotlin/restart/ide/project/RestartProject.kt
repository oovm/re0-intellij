package restart.ide.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentIterator
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import restart.ide.file.RestartFileNode
import restart.language.psi_node.RestartPropertyStatementNode

class RestartProject() {
    companion object {
        fun getFiles(project: Project?): RestartInfoStorage {
            val store = RestartInfoStorage(project);
            project ?: return store;
            ProjectFileIndex.getInstance(project).iterateContent {
                store.processFile(it)
            }
            return store
        }
    }
}

// TODO: cache
class RestartInfoStorage(val project: Project?) : ContentIterator {
    private var files: MutableList<RestartFileNode> = mutableListOf()
    override fun processFile(fileInProject: VirtualFile): Boolean {
        project ?: return false
        val file = PsiManager.getInstance(project).findFile(fileInProject) as? RestartFileNode
        if (file != null) {
            files.add(file)
        }
        return true
    }

    fun analyzeProperty(): MutableMap<String, RestartPropertyStatementNode> {
        val map = mutableMapOf<String, RestartPropertyStatementNode>()
        for (file in files) {
            file.findProperty(map)
        }
        return map
    }
}