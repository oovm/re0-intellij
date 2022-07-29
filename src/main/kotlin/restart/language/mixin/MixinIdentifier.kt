package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement
import restart.ide.reference.RestartReference
import restart.language.ast.RestartASTBase
import restart.language.psi_node.*
import restart.language.psi_node.RestartDeclareKeyNode
import restart.language.psi_node.RestartDeclareStatement

open class MixinIdentifier(node: ASTNode) : RestartASTBase(node), PsiNamedElement {
    override fun getName(): String? {
        return null
    }

    override fun setName(name: String): PsiElement {
        return this
    }

    override fun getReference(): RestartReference? = when {
        shouldResolve() -> RestartReference(this)
        else -> null
    }

    override fun getReferences(): Array<RestartReference> = when (val r = reference) {
        null -> arrayOf()
        else -> arrayOf(r)
    }

    fun getNormalizedName(): String {
        return this.text.trim('`')
    }

    fun isKeywordName(): Boolean = when (this.text) {
        "属性" -> true
        else -> false
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

