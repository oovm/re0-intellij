package restart.language.ast

import com.intellij.psi.PsiComment
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import restart.language.psi.RestartTypes

class DocumentNode(comment: PsiComment, rawText: String? = null) : RestartASTBase(comment.node),
    PsiDocCommentBase {

    private val documentText: String

    init {
        this.documentText = rawText?.trimIndent() ?: "[PARSE_FAILED]: ${comment.text}"
    }

    override fun getTokenType(): IElementType = RestartTypes.COMMENT_TEXT
    override fun getOwner(): PsiElement? {
        TODO("Not yet implemented")
    }

    fun render(): String {
        return "<div>$documentText<div>"
    }

    companion object {
        fun tryBuild(comment: PsiElement): DocumentNode? = when (comment) {
            is PsiComment -> tryBuild(comment)
            else -> null
        }

        fun tryBuild(node: PsiComment): DocumentNode? {
            return when (node.prevSibling.text) {
                "///" -> {
                    DocumentNode(node, node.text)
                }

                else -> {
                    null
                }
            }
        }
    }
}