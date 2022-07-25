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

    override fun getReference(): RestartReference? {
        when (val parent = this.parent) {
            is RestartModifiers, is RestartPropertyStatement -> {
                return null
            }
            is RestartTalentStatement, is RestartEventStatement, is RestartHeroStatement, is RestartArchiveStatement -> {
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

