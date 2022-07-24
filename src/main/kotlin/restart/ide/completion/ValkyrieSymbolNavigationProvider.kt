package restart.ide.completion

import com.intellij.model.Symbol
import com.intellij.navigation.NavigationTarget
import com.intellij.navigation.SymbolNavigationProvider
import com.intellij.openapi.project.Project


@Suppress("UnstableApiUsage")
class ValkyrieSymbolNavigationProvider : SymbolNavigationProvider {
    override fun getNavigationTargets(project: Project, symbol: Symbol): MutableCollection<out NavigationTarget> {
        TODO("Not yet implemented")
    }
}