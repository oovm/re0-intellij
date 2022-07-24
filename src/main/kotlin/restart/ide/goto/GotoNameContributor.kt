package restart.ide.goto

import com.intellij.navigation.ChooseByNameContributor
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project
import restart.ide.project.RestartProject

class GotoNameContributor : ChooseByNameContributor {
    override fun getNames(project: Project?, includeNonProjectItems: Boolean): Array<String> {
        return RestartProject.getFiles(project)
            .analyzeProperty().keys.toTypedArray()
    }

    override fun getItemsByName(name: String?, pattern: String?, project: Project?, includeNonProjectItems: Boolean): Array<NavigationItem> {
        val items = RestartProject.getFiles(project).analyzeProperty()[name]
        return items?.let { arrayOf(it) } ?: arrayOf()
    }
}