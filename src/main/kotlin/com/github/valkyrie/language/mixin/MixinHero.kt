package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi_node.ValkyrieHeroStatementNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

// PsiReference
open class MixinHero(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieHeroStatementNode {
       return this as ValkyrieHeroStatementNode
    }
    override fun getNameIdentifier(): PsiElement = originalElement.identifier
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Class
    override fun setName(name: String): PsiElement {
        return this.nameIdentifier
    }
}

