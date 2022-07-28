package restart.language.mixin

import com.intellij.lang.ASTNode
import restart.ide.reference.RestartReference
import restart.language.ast.RestartASTBase
import restart.language.psi.*
import restart.language.psi_node.RestartDeclareKeyNode

open class MixinIdentifier(node: ASTNode) : RestartASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }

    override fun getReference(): RestartReference? = when {
        shouldResolve() -> RestartReference(this)
        else -> null
    }

    override fun getReferences(): Array<RestartReference> = when (val r = reference) {
        null -> arrayOf()
        else -> arrayOf(r)
    }

    fun shouldResolve(): Boolean {
        return when (val parent = this.parent) {
            is RestartModifiers, is RestartDeclareStatement -> {
                false
            }
            is RestartDeclareKeyNode -> {
                when {
                    parent.underDeclareStatement() -> {
                        false
                    }
                    else -> {
                        true
                    }
                }
            }
            else -> true
        }
    }
}

