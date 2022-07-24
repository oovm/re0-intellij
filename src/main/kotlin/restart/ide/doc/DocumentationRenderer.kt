package restart.ide.doc

import restart.RestartLanguage
import restart.ide.highlight.RestartHighlightColor
import restart.ide.highlight.RestartHighlightColor.*
import restart.language.symbol.KeywordData
import restart.language.symbol.ModifierData
import restart.language.symbol.OperatorData
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.richcopy.HtmlSyntaxInfoUtil
import com.intellij.psi.PsiElement
import com.intellij.ui.ColorUtil

class DocumentationRenderer(var element: PsiElement, private var original: PsiElement?) {
    private val doc = StringBuilder()
    fun onHover(): String {
        val keyword = KeywordData.builtinData(element);
        when {
            keyword != null -> {
                keyword.documentation(this)
            }
            else -> {
                when (element) {
//                    is RestartTraitStatementNode -> buildShort(element as RestartTraitStatementNode)
//                    is RestartClassStatementNode -> buildShort(element as RestartClassStatementNode)
                    else -> doc.append("onHover: ${element.text}")
                }
            }
        }
        return doc.toString()
    }

    fun onDetail(): String {
        when (val tokens = KeywordData.builtinData(element)) {
            null -> {}
            else -> {
                tokens.documentation(this)
                return doc.toString()
            }
        }
        when (val tokens = OperatorData.builtinData(element)) {
            null -> {}
            else -> {
                tokens.documentation(this)
                return doc.toString()
            }
        }
        when (val tokens = ModifierData.builtinData(element)) {
            null -> {}
            else -> {
                tokens.documentation(this)
                return doc.toString()
            }
        }

        when (element) {
//            is RestartTraitStatementNode -> buildDetail(element as RestartTraitStatementNode)
//            is RestartClassStatementNode -> buildShort(element as RestartClassStatementNode)
            else -> {
                doc.append(element)
                doc.append("<br/>")
                doc.append(original)
                doc.append("<br/>")
                doc.append("onDetail: ${element.text}")
            }
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

//    private fun buildDetail(element: RestartTraitStatementNode) {
//        this.buildShort(element)
//    }
//
//    private fun buildShort(element: RestartClassStatementNode) {
//        append(KEYWORD, "crate ")
//        appendNamespace()
//        doc.append("<br/>")
//        append(KEYWORD, "public ")
//        append(KEYWORD, "native ")
//        append(KEYWORD, "class ")
//        append(SYM_CLASS, element.name)
////        appendNewline()
////        append(KEYWORD, "implements ")
////        append(SYM_TRAIT, "Eq")
////        appendAdd()
////        append(SYM_TRAIT, "Hash")
//    }


    /// get the path relative to the project root
    /// FIXME: get real declare module
    private fun appendNamespace() {
        val file = element.containingFile;
        // fake module path
        val path = file.virtualFile.path.substringAfter("src/").replace("/", "::").replace(".vk", "")
        append(path)
    }

    fun append(text: String) {
        doc.append("<span>${text}</span>")
    }

    fun append(key: RestartHighlightColor, text: String) {
        // HtmlSyntaxInfoUtil.getStyledSpan(key.textAttributesKey, text, 1.0f)
        val attr = EditorColorsManager.getInstance().globalScheme.getAttributes(key.textAttributesKey)
        val color = ColorUtil.toHtmlColor(attr.foregroundColor)
        doc.append("<span style='color:${color}'>${text}</span>")
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


