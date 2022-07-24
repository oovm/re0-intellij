package restart.language.ast

import restart.ide.file.RestartIconProvider
import restart.ide.highlight.RestartHighlightColor
import restart.ide.view.RestartViewElement
import restart.language.psi.*
import com.intellij.ide.projectView.PresentationData
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil


fun RestartModifiers?.addChildrenView(list: MutableList<RestartViewElement>) {
    if (this == null) return
    PsiTreeUtil
        .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
        .forEach {
            // PresentationData(it.text, "std::modifiers", this.getIcon(0), null)
            val view = PresentationData(it.text, "", this.getIcon(0), null)
            list.add(RestartViewElement(it, view))
        }
}