@file:Suppress("UnstableApiUsage")

package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.RestartASTBase
import com.github.valkyrie.language.psi_node.ValkyrieDeclareStatementNode
import com.github.valkyrie.language.symbol.ImportData
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiCompletableReference
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiReference
import javax.swing.Icon

open class MixinDeclare(node: ASTNode) : RestartASTBase(node) {
    override fun getOriginalElement(): ValkyrieDeclareStatementNode {
        return this as ValkyrieDeclareStatementNode
    }
    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.IMPORT

    override fun getPresentation(): ItemPresentation? {
        return null
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        return arrayOf()
    }

    override fun getReference(): PsiReference? {
        return when {
            references.count() != 1 -> null
            else -> references.first()
        }
    }

    override fun getReferences(): Array<PsiReference> {
        return  ownReferences.map { it as PsiReference }.toTypedArray()
    }

    override fun getOwnDeclarations(): MutableCollection<out ImportData> {
        return mutableListOf()
    }

    override fun getOwnReferences(): MutableCollection<out PsiCompletableReference> {
        return mutableListOf()
    }
}

