package com.github.valkyrie.ide.reference.declaration_range

import com.github.valkyrie.language.psi.endOffset
import com.github.valkyrie.language.psi.startOffset
import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.hint.DeclarationRangeHandler
import com.intellij.openapi.util.TextRange

@Suppress("UnstableApiUsage")
class ClassDeclarationHandler : DeclarationRangeHandler<ValkyrieClassStatementNode> {
    override fun getDeclarationRange(container: ValkyrieClassStatementNode): TextRange {
        val startOffset = container.startOffset
        val endOffset = container.endOffset
        return TextRange(startOffset, endOffset)
    }
}
//
//class RsStructItemDeclarationRangeHandler : DeclarationRangeHandler<RsStructItem> {
//    override fun getDeclarationRange(container: RsStructItem): TextRange {
//        val startOffset = (container.struct ?: container.union ?: container).startOffset
//        val endOffset = (container.blockFields?.getPrevNonCommentSibling() ?: container).endOffset
//        return TextRange(startOffset, endOffset)
//    }
//}
//
//class RsTraitItemDeclarationRangeHandler : DeclarationRangeHandler<RsTraitItem> {
//    override fun getDeclarationRange(container: RsTraitItem): TextRange {
//        val startOffset = container.trait.startOffset
//        val endOffset = (container.members?.getPrevNonCommentSibling() ?: container).endOffset
//        return TextRange(startOffset, endOffset)
//    }
//}
//
//class RsImplItemDeclarationRangeHandler : DeclarationRangeHandler<RsImplItem> {
//    override fun getDeclarationRange(container: RsImplItem): TextRange {
//        val startOffset = container.impl.startOffset
//        val endOffset = (container.members?.getPrevNonCommentSibling() ?: container).endOffset
//        return TextRange(startOffset, endOffset)
//    }
//}
//
//class RsEnumItemDeclarationRangeHandler : DeclarationRangeHandler<RsEnumItem> {
//    override fun getDeclarationRange(container: RsEnumItem): TextRange {
//        val startOffset = container.enum.startOffset
//        val endOffset = (container.enumBody?.getPrevNonCommentSibling() ?: container).endOffset
//        return TextRange(startOffset, endOffset)
//    }
//}
//
//class RsModItemDeclarationRangeHandler : DeclarationRangeHandler<RsModItem> {
//    override fun getDeclarationRange(container: RsModItem): TextRange {
//        val startOffset = container.mod.startOffset
//        val endOffset = container.identifier.endOffset
//        return TextRange(startOffset, endOffset)
//    }
//}
//
//class RsFunctionDeclarationRangeHandler : DeclarationRangeHandler<RsFunction> {
//    override fun getDeclarationRange(container: RsFunction): TextRange {
//        val startOffset = container.fn.startOffset
//        val endOffset = (container.block?.getPrevNonCommentSibling() ?: container).endOffset
//        return TextRange(startOffset, endOffset)
//    }
//}
//
//class RsMacroDeclarationRangeHandler : DeclarationRangeHandler<RsMacro> {
//    override fun getDeclarationRange(container: RsMacro): TextRange =
//        container.identifier?.textRange ?: container.textRange
