package restart.ide.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import restart.language.psi.RestartBraceBlock
import restart.language.psi.RestartRecursiveVisitor
import restart.language.psi.endOffset
import restart.language.psi.startOffset

class RestartFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : RestartRecursiveVisitor() {
    override fun visitBraceBlock(o: RestartBraceBlock) {
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


