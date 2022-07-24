package restart.language.ast

import restart.ide.file.ValkyrieIconProvider
import restart.ide.highlight.ValkyrieHighlightColor
import restart.ide.view.ValkyrieViewElement
import restart.language.psi.*
import com.intellij.ide.projectView.PresentationData
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil


fun ValkyrieModifiers?.addChildrenView(list: MutableList<ValkyrieViewElement>) {
    if (this == null) return
    PsiTreeUtil
        .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
        .forEach {
            // PresentationData(it.text, "std::modifiers", this.getIcon(0), null)
            val view = PresentationData(it.text, "", this.getIcon(0), null)
            list.add(ValkyrieViewElement(it, view))
        }
}