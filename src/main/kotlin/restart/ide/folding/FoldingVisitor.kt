package restart.ide.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import restart.language.psi.RestartRecursiveVisitor
import restart.language.psi.RestartTypes
import restart.language.psi.childrenWithLeaves
import restart.language.psi_node.*

class FoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : RestartRecursiveVisitor() {
    override fun visitDeclareBlock(o: RestartDeclareBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitDeclareItem(o: RestartDeclareItem) {
        var start = o.firstChild.endOffset
        val end = o.lastChild.startOffset
        for (item in o.childrenWithLeaves) {
            when (item.elementType) {
                RestartTypes.BRACKET_L -> start = item.endOffset
                RestartTypes.BRACKET_R -> fold(o.node, start, end)
                else -> {}
            }
        }
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


