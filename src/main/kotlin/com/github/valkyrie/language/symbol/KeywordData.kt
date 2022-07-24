@file:Suppress("ConvertSecondaryConstructorToPrimary", "MemberVisibilityCanBePrivate", "UnstableApiUsage")

package com.github.valkyrie.language.symbol

import com.github.valkyrie.ide.doc.DocumentationRenderer
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.language.psi.RestartTypes
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
        doc.append(ValkyrieHighlightColor.KEYWORD, "keyword ")
        doc.append(ValkyrieHighlightColor.SYM_MACRO, name)
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