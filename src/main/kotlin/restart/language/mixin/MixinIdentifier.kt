package restart.language.mixin

import com.intellij.lang.ASTNode
import restart.ide.reference.RestartReference
import restart.language.ast.RestartASTBase
import restart.language.psi.RestartDeclareStatement
import restart.language.psi.RestartModifiers
import restart.language.psi.ancestors

open class MixinIdentifier(node: ASTNode) : RestartASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }

    override fun getReference(): RestartReference? {
        return if (this.parent is RestartModifiers) {
            print(ancestors)
            null
        } else if (ancestors.drop(3).firstOrNull() is RestartDeclareStatement) {
            null
        } else {
            RestartReference(this)
        }
    }

    override fun getReferences(): Array<RestartReference> = when (val r = reference) {
        null -> arrayOf()
        else -> arrayOf(r)
    }

    override fun canNavigate(): Boolean {
        return when (this.parent) {
            is RestartModifiers -> false
            else -> true
        }
    }
}

