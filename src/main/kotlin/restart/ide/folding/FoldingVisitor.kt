package restart.ide.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import restart.language.psi.*

class FoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : RestartRecursiveVisitor() {
    override fun visitDeclareBlock(o: RestartDeclareBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }


    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }

    private fun fold(node: ASTNode, range: TextRange) {
        descriptors += FoldingDescriptor(node, range)
    }

    private fun fold(node: ASTNode, start: Int, end: Int) = when {
        end > start -> {
            descriptors += FoldingDescriptor(node, TextRange(start, end))
        }

        else -> {}
    }
}


