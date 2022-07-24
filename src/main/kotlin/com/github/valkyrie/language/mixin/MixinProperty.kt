@file:Suppress("UnstableApiUsage")

package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.ast.addChildrenView
import com.github.valkyrie.language.psi_node.ValkyrieVariableStatementNode
import com.github.valkyrie.language.symbol.NamespaceData
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.model.psi.*
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

open class MixinProperty(node: ASTNode) : DeclareNode(node),
    PsiNameIdentifierOwner {
    override fun getOriginalElement(): ValkyrieVariableStatementNode {
        return this as ValkyrieVariableStatementNode
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getIcon(flags: Int): Icon {
        TODO("Not yet implemented")
    }


    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val views: MutableList<ValkyrieViewElement> = mutableListOf()
//        for (item in PsiTreeUtil.getChildrenOfTypeAsList(containingFile, ValkyrieImportStatementNode::class.java)) {
//            item.addChildrenView(views)
//        }
        return views.toTypedArray()
    }
}

