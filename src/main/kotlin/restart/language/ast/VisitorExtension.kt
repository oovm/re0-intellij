package restart.language.ast

import com.intellij.ide.projectView.PresentationData
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import restart.ide.view.RestartViewElement
import restart.language.psi_node.RestartModifiers


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