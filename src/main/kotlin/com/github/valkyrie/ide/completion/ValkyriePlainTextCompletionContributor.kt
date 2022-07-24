package com.github.valkyrie.ide.completion

import com.intellij.codeInsight.completion.PlainTextSymbolCompletionContributor
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.psi.PsiFile

/// 在提交记录里面触发
class ValkyriePlainTextCompletionContributor : PlainTextSymbolCompletionContributor {
    override fun getLookupElements(file: PsiFile, invocationCount: Int, prefix: String): MutableCollection<LookupElement> {
        TODO("Not yet implemented")
    }
}