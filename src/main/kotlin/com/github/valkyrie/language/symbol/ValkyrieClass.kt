package com.github.valkyrie.language.symbol

import com.intellij.icons.AllIcons
import com.intellij.lang.documentation.DocumentationTarget
import com.intellij.model.presentation.SymbolPresentation
import com.intellij.navigation.NavigationRequest
import com.intellij.navigation.NavigationTarget
import com.intellij.navigation.TargetPresentation
import com.intellij.openapi.project.Project

@Suppress("UnstableApiUsage")
class ValkyrieClass(namespace: String) : ValkyrieSymbol() {
    init {
        this.fullName = namespace.split(".")
    }
    val presentation: TargetPresentation = TargetPresentation
        .builder("aa").presentation()
    //    constructor(editor: Editor) : this(name) {
//
//    }
    override fun isStructure(): Boolean = true

    override fun getSymbolPresentation(): SymbolPresentation {
        return SymbolPresentation.create(AllIcons.General.Web, "short", "detail")
    }

    override fun getNavigationTargets(project: Project): Collection<NavigationTarget> = listOf(this)
    override fun getDocumentationTarget(): DocumentationTarget {
        TODO("Not yet implemented")
    }

    override fun getTargetPresentation(): TargetPresentation = TODO(
        "In all known cases the symbol doesn't appear in the disambiguation popup, " +
            "because this symbol is usually alone, so no popup required. Implement this method when needed."
    )

    override fun navigationRequest(): NavigationRequest? {
        return null
    }
}
