package restart.ide.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentIterator
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import restart.ide.file.RestartFileNode

class RestartProject() {
    companion object {
        fun getFiles(project: Project): MutableList<PsiFile> {
            val iter = ProjectFileIterator(project);
            ProjectFileIndex.getInstance(project).iterateContent {
                iter.processFile(it)
            }
            return iter.files
        }
    }
}

class ProjectFileIterator(val project: Project) : ContentIterator {
    var files: MutableList<PsiFile> = mutableListOf()
    override fun processFile(fileInProject: VirtualFile): Boolean {
        val file = PsiManager.getInstance(project).findFile(fileInProject) as? RestartFileNode
        analizeFile(file)
        if (file != null) {
            files.add(file)
        }
        return true
    }

    private fun analizeFile(file: RestartFileNode?) {
        if (file is RestartFileNode) {
            files.add(file)
        }
    }
}