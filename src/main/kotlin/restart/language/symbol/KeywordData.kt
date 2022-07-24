@file:Suppress("ConvertSecondaryConstructorToPrimary", "MemberVisibilityCanBePrivate", "UnstableApiUsage")

package restart.language.symbol

import restart.ide.doc.DocumentationRenderer
import restart.ide.highlight.RestartHighlightColor
import restart.language.psi.RestartTypes
import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType

class KeywordData : Symbol, Pointer<KeywordData> {
    val name: String
    val detail: String
    constructor(name: String, detail: String = "") {
        this.name = name
        this.detail = detail
    }
    override fun createPointer(): Pointer<out KeywordData> = this
    override fun dereference(): KeywordData = this
    fun documentation(doc: DocumentationRenderer) {
        doc.append(RestartHighlightColor.KEYWORD, "keyword ")
        doc.append(RestartHighlightColor.SYM_MACRO, name)
        doc.append("<hr/>")
        doc.append(detail)
    }


    companion object {
        fun builtinData(name: PsiElement): KeywordData? = when (name.elementType) {
            RestartTypes.KW_ELSE_IF -> KeywordData(
                "class",
                """
                class A()
                """.trimIndent()
            )
            RestartTypes.KW_EVENT -> KeywordData(
                "trait",
                """
                trait A()
                """.trimIndent()
            )
            else -> null
        }
    }


}