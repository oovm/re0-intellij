package com.github.valkyrie.ide.goto

import com.github.valkyrie.language.symbol.ValkyrieSymbol
import com.intellij.model.Symbol
import com.intellij.navigation.NavigationTarget
import com.intellij.navigation.SymbolNavigationProvider
import com.intellij.openapi.project.Project

@Suppress("UnstableApiUsage")
class VSymbolNavigationProvider : SymbolNavigationProvider {
    override fun getNavigationTargets(project: Project, symbol: Symbol): MutableCollection<out NavigationTarget> {
        val sym = symbol as? ValkyrieSymbol ?: return mutableSetOf()
        TODO("Not yet implemented $project, $sym")
    }
}

