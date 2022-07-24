package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import restart.ide.reference.RestartReference
import restart.language.ast.RestartASTBase

open class MixinIdentifier(node: ASTNode) : RestartASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }

    override fun getReference(): PsiReference? {
        return references.firstOrNull()
    }

    override fun getReferences(): Array<RestartReference> {
        return arrayOf(RestartReference(this))
    }
}

