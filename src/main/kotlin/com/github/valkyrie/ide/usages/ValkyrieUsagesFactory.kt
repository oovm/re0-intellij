package com.github.valkyrie.ide.usages

import com.github.valkyrie.language.psi.ValkyrieDeclareStatement
import com.github.valkyrie.language.psi.ValkyrieVariableStatement
import com.github.valkyrie.language.psi_node.*
import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.psi.PsiElement

class ValkyrieUsagesFactory : FindUsagesHandlerFactory() {
    override fun canFindUsages(element: PsiElement): Boolean {
        return when (element) {
            is ValkyrieDeclareStatement,
            is ValkyrieVariableStatement,
            -> true
            else -> false
        }
    }

    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler? {
        return when (element) {
            is ValkyrieVariableStatement -> ValkyrieUsagesHandler(element)
            else -> null
        }
    }
}