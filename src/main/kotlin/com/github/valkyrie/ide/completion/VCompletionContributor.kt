package com.github.valkyrie.ide.completion

import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext

class VCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(ValkyrieTypes.IDENTIFIER),
            SymbolCompletionProvider()
        )
//        extend(
//            CompletionType.SMART,
//            PlatformPatterns.psiElement(PlainTextTokenTypes.PLAIN_TEXT),
//            BasicCompletionProvider()
//        )
//        extend(
//            CompletionType.CLASS_NAME,
//            PlatformPatterns.psiElement(PlainTextTokenTypes.PLAIN_TEXT),
//            BasicCompletionProvider()
//        )
    }

    class SymbolCompletionProvider : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet,
        ) {
            result.addElement(LookupElementBuilder.create("Hello World"))
        }
    }
}
