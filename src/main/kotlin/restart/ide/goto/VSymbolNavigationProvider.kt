package restart.ide.goto

import com.intellij.model.Symbol
import com.intellij.navigation.NavigationTarget
import com.intellij.navigation.SymbolNavigationProvider
import com.intellij.openapi.project.Project
import restart.language.symbol.RestartSymbol

@Suppress("UnstableApiUsage")
class VSymbolNavigationProvider : SymbolNavigationProvider {
    override fun getNavigationTargets(project: Project, symbol: Symbol): MutableCollection<out NavigationTarget> {
        val sym = symbol as? RestartSymbol ?: return mutableSetOf()
        TODO("Not yet implemented $project, $sym")
    }
}

