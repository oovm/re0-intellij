package com.github.valkyrie.ide.reference


import com.github.valkyrie.language.symbol.ValkyrieClass
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolDeclarationProvider
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class ValkyrieDeclarationProvider : PsiSymbolDeclarationProvider {
    override fun getDeclarations(element: PsiElement, offsetInElement: Int): MutableCollection<out PsiSymbolDeclaration> {
        return element.ownDeclarations
    }
}

