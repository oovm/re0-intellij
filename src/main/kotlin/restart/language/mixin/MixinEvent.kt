package restart.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import restart.language.ast.ASTFactory
import restart.language.ast.DeclareNode
import restart.language.psi_node.RestartEventStatementNode
import restart.language.psi_node.RestartIdentifierNode
import javax.swing.Icon

open class MixinEvent(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): RestartEventStatementNode {
        return this as RestartEventStatementNode
    }
    override fun getNameIdentifier(): RestartIdentifierNode {
        return originalElement.identifier as RestartIdentifierNode
    }
    override fun setName(name: String): PsiElement {
        return ASTFactory(this.project).replaceID(nameIdentifier, name)
    }
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Module
}

