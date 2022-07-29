package restart.ide.doc

import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.richcopy.HtmlSyntaxInfoUtil
import com.intellij.ui.ColorUtil
import restart.RestartLanguage
import restart.ide.doc.builtin.DocumentationBuiltinKeywords
import restart.ide.highlight.RestartHighlightColor
import restart.ide.highlight.RestartHighlightColor.*
import restart.language.ast.RestartASTBase
import restart.language.psi_node.RestartKwDeclareNode

class DocumentationRenderer(val element: RestartASTBase) {
    private val doc: StringBuilder = StringBuilder()
    fun onHover(): String {
        when (element) {
            is RestartKwDeclareNode -> buildShort(element)
            else -> doc.append("onHover: ${element.text}")
        }
        return doc.toString()
    }

    fun onDetail(): String {
        when (element) {
            is RestartKwDeclareNode -> buildDetail(element)
            else -> doc.append("onDetail: ${element.text}")
        }
        return doc.toString()
    }

//    private fun buildShort(element: RestartTraitStatementNode) {
//        append(KEYWORD, "crate ")
//        appendNamespace()
//        doc.append("<br/>")
//        append(KEYWORD, "public ")
//        append(KEYWORD, "native ")
//        append(KEYWORD, "trait ")
//        append(SYM_TRAIT, element.name)
//    }

    private fun buildDetail(element: RestartKwDeclareNode) {
        when (element.text) {
            "天赋" -> {
                doc.append(DocumentationBuiltinKeywords.talentDetail())
            }
            else -> {
                append(KEYWORD, element.text)
            }
        }
    }

    private fun buildShort(element: RestartKwDeclareNode) {
        when (element.text) {
            "天赋" -> {
                doc.append(DocumentationBuiltinKeywords.talentHover())
            }
            else -> {
                append(KEYWORD, element.text)
            }
        }
    }

    fun append(text: String) {
        doc.append("<span>${text}</span>")
    }

    fun append(key: RestartHighlightColor, text: String) {
        // HtmlSyntaxInfoUtil.getStyledSpan(key.textAttributesKey, text, 1.0f)
        doc.append("<span style='color:${key}'>${text}</span>")
    }

    private fun appendHighlight(code: String) {
        HtmlSyntaxInfoUtil.appendHighlightedByLexerAndEncodedAsHtmlCodeSnippet(
            doc,
            element.project,
            RestartLanguage,
            code.trimIndent(),
            1.0f,
        )
    }

    private fun appendAdd() {
        doc.append("<span>+</span>")
    }
}

private fun getColor(color: RestartHighlightColor): String {
    val attr = EditorColorsManager.getInstance().globalScheme.getAttributes(color.textAttributesKey)
    return ColorUtil.toHtmlColor(attr.foregroundColor)
}


