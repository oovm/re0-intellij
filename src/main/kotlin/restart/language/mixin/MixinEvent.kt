package restart.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import restart.language.ast.DeclareNode
import restart.language.psi_node.RestartEventStatementNode
import javax.swing.Icon

open class MixinEvent(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): RestartEventStatementNode {
        return this as RestartEventStatementNode
    }

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Module

    override fun getNameIdentifier(): PsiElement {
        return originalElement.firstChild
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

