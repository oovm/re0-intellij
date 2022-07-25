package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.parents
import restart.language.ast.RestartASTBase

open class MixinDeclareItem(node: ASTNode) : RestartASTBase(node) {


    override fun getOriginalElement(): PsiElement {
        return super.getOriginalElement()
    }

    fun canIndent(child: ASTNode): Boolean {
        return when {
            node.lastChildNode == child -> {
                false
            }
            node.firstChildNode == child -> {
                false
            }
            else -> {
                true
            }
        }
    }
}

