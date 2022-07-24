package restart.language.mixin

import restart.language.ast.DeclareNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import restart.language.psi_node.RestartArchiveStatementNode
import javax.swing.Icon

open class MixinAward(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): RestartArchiveStatementNode {
        return this as RestartArchiveStatementNode
    }

    override fun getNameIdentifier(): PsiElement = originalElement
    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Enum
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

