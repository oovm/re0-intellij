package restart.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import restart.language.ast.DeclareNode
import restart.language.psi_node.RestartIdentifierNode
import restart.language.psi_node.RestartTalentStatementNode
import javax.swing.Icon

// PsiReference
open class MixinTalent(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): RestartTalentStatementNode {
        return this as RestartTalentStatementNode
    }
    override fun getNameIdentifier(): RestartIdentifierNode {
        return originalElement.identifier as RestartIdentifierNode
    }
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Class
    override fun setName(name: String): PsiElement {
        return this.nameIdentifier
    }
}

