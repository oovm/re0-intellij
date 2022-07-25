package restart.language.ast

import com.intellij.formatting.Block
import com.intellij.formatting.Spacing
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.util.elementType
import restart.ide.formatter.FormatSpace
import restart.language.psi.RestartIdentifier
import restart.language.psi.RestartNumber
import restart.language.psi.RestartTypes




fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun Block.computeSpacing(child1: Block?, child2: Block, ctx: FormatSpace): Spacing? {
    return ctx.spacingBuilder.getSpacing(this, child1, child2)
}
