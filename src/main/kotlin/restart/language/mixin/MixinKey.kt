package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.parents
import restart.language.ast.RestartASTBase

open class MixinKey(node: ASTNode) : RestartASTBase(node) {

    override fun getName(): String? {
        return super.getName()
    }

    override fun getOriginalElement(): PsiElement {
        return super.getOriginalElement()
    }

    fun underDeclareStatement(): Boolean {
        when (  this.parents(false).drop(2).firstOrNull()) {

        }
        return true
    }

}

