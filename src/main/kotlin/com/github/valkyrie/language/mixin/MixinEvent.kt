package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi_node.ValkyrieEventStatementNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinEvent(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieEventStatementNode {
        return this as ValkyrieEventStatementNode
    }
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Module

    override fun getNameIdentifier(): PsiElement {
        return originalElement.firstChild
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

