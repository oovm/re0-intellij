package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.parents
import restart.language.ast.RestartASTBase
import restart.language.psi_node.RestartDeclareKeyNode

open class MixinKey(node: ASTNode) : RestartASTBase(node) {
    override fun getOriginalElement(): RestartDeclareKeyNode {
        return this as RestartDeclareKeyNode
    }
    override fun getName(): String {
        return this.text.trim('`')
    }
    fun underDeclareStatement(): Boolean {
        when (this.parents(false).drop(2).firstOrNull()) {

        }
        return true
    }

}

