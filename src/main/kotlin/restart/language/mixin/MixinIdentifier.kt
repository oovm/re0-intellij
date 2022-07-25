package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiNamedElement
import restart.ide.reference.RestartReference
import restart.language.ast.RestartASTBase
import restart.language.psi.RestartModifiers
import restart.language.psi.RestartPropertyStatement
import restart.language.psi_node.RestartDeclareKeyNode
import restart.language.psi_node.RestartIdentifierNode

open class MixinIdentifier(node: ASTNode) : RestartASTBase(node), PsiNamedElement {
    override fun getName(): String {
        return this.text.trim('`')
    }

    override fun setName(name: String): RestartIdentifierNode {
        return this as RestartIdentifierNode
    }

    override fun getReference(): RestartReference? {
        when (val parent = this.parent) {
            is RestartModifiers -> {
                return null
            }

            is RestartPropertyStatement -> {
                return null
            }

            is RestartDeclareKeyNode -> {
                if (parent.underDeclareStatement()) {
                    return null
                }
            }
        }
        return RestartReference(this)
    }

    override fun getReferences(): Array<RestartReference> = when (val r = reference) {
        null -> arrayOf()
        else -> arrayOf(r)
    }

}

