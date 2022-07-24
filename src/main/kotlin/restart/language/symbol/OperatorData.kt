package restart.language.symbol

import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import restart.ide.doc.DocumentationRenderer
import restart.ide.highlight.RestartHighlightColor
import restart.language.psi.RestartTypes

@Suppress("MemberVisibilityCanBePrivate")
class OperatorData(
    val name: String,
    val symbol: String,
    val detail: String = "",
    val associative: OperatorAssociativity = OperatorAssociativity.NONE,
    val priority: Int = 100,
) {
    fun documentation(doc: DocumentationRenderer) {
        doc.append(RestartHighlightColor.KEYWORD, "operator ")
        doc.append(RestartHighlightColor.SYM_MACRO, symbol)
        doc.append(RestartHighlightColor.KEYWORD, " de-sugars ")
        doc.append(RestartHighlightColor.SYM_FUNCTION_FREE, name)
        doc.append("<br/>")
        doc.append(RestartHighlightColor.KEYWORD, "associative ")
        doc.append(RestartHighlightColor.SYM_MACRO, associative.toString())
        doc.append("<br/>")
        doc.append(RestartHighlightColor.KEYWORD, "priority ")
        doc.append(RestartHighlightColor.SYM_CONSTANT, priority.toString())
        doc.append("<hr/>")
        doc.append(detail)
    }

    companion object {
        fun builtinData(name: PsiElement): OperatorData? = when (name.elementType) {
            RestartTypes.OP_ADD -> OperatorData(
                "add",
                "+",
                """
                a + b
                """.trimIndent()
            )

            RestartTypes.OP_INC -> OperatorData(
                "++",
                "increase",
                """
                a ++ b
                ++a
                """.trimIndent()
            )

            else -> null
        }
    }
}