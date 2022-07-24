package restart.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import restart.ide.view.RestartViewElement
import restart.language.symbol.RestartSymbolKind

open class RestartASTBase(node: ASTNode) : ASTWrapperPsiElement(node) {
    fun collectDocuments(): List<PsiElement> {
        return listOf()
    }

   open fun getKind(): RestartSymbolKind {
        return RestartSymbolKind.Unknown
    }

    fun collectAnnotations(): List<PsiElement> {
        return listOf()
    }

    open fun getChildrenView(): Array<RestartViewElement> {
        val childrenView: MutableList<RestartViewElement> = mutableListOf()
        for (item in PsiTreeUtil.getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)) {
            childrenView.add(RestartViewElement(item))
        }
        return childrenView.toTypedArray()
    }
}