package restart.language.mixin

import restart.language.ast.RestartASTBase
import restart.language.psi.RestartTypes
import restart.language.psi_node.RestartIdentifierNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

open class MixinNamepath(node: ASTNode) : RestartASTBase(node) {
//    override fun getOriginalElement(): PsiElement = this
//    override fun getIcon(flags: Int): Icon {
//        TODO("Not yet implemented")
//    }
//
//    override fun getNavigationElement(): PsiElement {
//        TODO("Not yet implemented")
//    }

    override fun getName(): String? {
        return children
            .filterIsInstance<RestartIdentifierNode>()
            .joinToString("∷") { it.name }
    }


    fun delimiterList(): List<PsiElement> {
        return this.children.filter {
            it.elementType == RestartTypes.DOT || it.elementType == RestartTypes.OP_PROPORTION
        }
    }
}

