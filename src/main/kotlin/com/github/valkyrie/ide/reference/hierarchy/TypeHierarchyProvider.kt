package com.github.valkyrie.ide.reference.hierarchy

import com.intellij.ide.hierarchy.HierarchyBrowser
import com.intellij.ide.hierarchy.HierarchyProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.psi.PsiElement

class TypeHierarchyProvider : HierarchyProvider {
    override fun getTarget(dataContext: DataContext): PsiElement? {
        return null
    }

    override fun createHierarchyBrowser(target: PsiElement): HierarchyBrowser {
        TODO("Not yet implemented")
    }

    override fun browserActivated(hierarchyBrowser: HierarchyBrowser) {
        TODO("Not yet implemented")
    }
}