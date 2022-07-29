@file:Suppress("ConvertSecondaryConstructorToPrimary", "MemberVisibilityCanBePrivate", "UnstableApiUsage")

package restart.language.symbol

import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.psi.util.elementType
import restart.ide.doc.DocumentationRenderer
import restart.ide.highlight.RestartHighlightColor
import restart.language.psi.RestartTypes

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
        doc.append(RestartHighlightColor.METADATA, name)
        doc.append("<hr/>")
        doc.append(detail)
    }


    companion object {
        private fun getAll(): MutableSet<KeywordData> {
            return mutableSetOf(
                KeywordData(
                    "class",
                    """
                class A()
                """.trimIndent()
                ),
            )
        }

        val DATABASE: Map<String, KeywordData>
            get() {
                val db = mutableMapOf<String, KeywordData>()
                for (data in getAll()) {
                    db[data.name] = data
                }
                return db
            }

        fun builtinData(name: String): KeywordData? = DATABASE[name]
    }
}