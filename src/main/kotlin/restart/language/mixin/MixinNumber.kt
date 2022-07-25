package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.util.elementType
import restart.language.ast.RestartASTBase
import restart.language.psi.RestartTypes

// PsiReference
open class MixinNumber(node: ASTNode) : RestartASTBase(node), PsiNamedElement {
    val identifier: PsiElement?
        get() = when (this.lastChild.elementType) {
            RestartTypes.NUMBER_SUFFIX -> this.lastChild!!
            else -> null
        }

    fun getStringText(): String {
        return this.children.reversed()[2].text
    }

    override fun getName(): String? {
        return identifier?.text
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getTextOffset(): Int {
        return identifier?.textOffset ?: super.getTextOffset()
    }
}

