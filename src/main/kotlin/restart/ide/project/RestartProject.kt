package restart.ide.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectFileIndex


class RestartProject {
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


