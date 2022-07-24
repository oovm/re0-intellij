package restart.language.ast

import com.intellij.formatting.Block
import com.intellij.formatting.Spacing
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.util.elementType
import restart.ide.formatter.FormatSpace
import restart.language.psi.RestartIdentifier
import restart.language.psi.RestartNormalPattern
import restart.language.psi.RestartNumber
import restart.language.psi.RestartTypes


val RestartNumber?.identifier: PsiElement?
    get() {
        val last = this?.lastChild ?: return null
        return when (last.elementType) {
            RestartTypes.NUMBER_SUFFIX -> last
            else -> null
        }
    }

fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun Block.computeSpacing(child1: Block?, child2: Block, ctx: FormatSpace): Spacing? {
    return ctx.spacingBuilder.getSpacing(this, child1, child2)
}

fun hasModifier(node: List<RestartIdentifier>, modifier: String, skip_last: Boolean = true): Boolean {
    val size = node.size - if (skip_last) {
        1
    } else {
        0
    }
    for (i in 0 until size) {
        if (node[i].text == modifier) {
            return true
        }
    }
    return false
}

fun RestartNormalPattern.isMutable(): Boolean {
    return hasModifier(this.identifierList, "mut", false)
}

//fun RestartPatternRest?.hasModifier(modifier: String, skip_last: Boolean = true): Boolean {
//    return getModifier(this as PsiElement, modifier, skip_last)
//}
//
//
//fun RestartPatternItem.isMutable(force_mut: Boolean, skip_last: Boolean = true): Boolean {
//    this.modifierSymbols?.let {
//        return it.isMutable(force_mut, skip_last)
//    }
//    this.patternRest?.let {
//        return it.isMutable(force_mut, skip_last)
//    }
//    return false
//}
//
//fun RestartModifiers?.isMutable(force_mut: Boolean, skip_last: Boolean = true): Boolean = when (force_mut) {
//    true -> true
//    false -> this?.hasModifier("mut", skip_last) ?: false
//}
//
//fun RestartPatternRest?.isMutable(force_mut: Boolean, skip_last: Boolean = true): Boolean = when (force_mut) {
//    true -> true
//    false -> this?.hasModifier("mut", skip_last) ?: false
//}
//
