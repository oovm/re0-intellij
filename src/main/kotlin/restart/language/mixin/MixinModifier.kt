package restart.language.mixin

import restart.ide.file.RestartIconProvider
import restart.ide.view.RestartViewElement
import restart.language.ast.ViewableNode
import restart.language.psi.RestartModifiers
import restart.language.psi_node.RestartModifiersNode
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

open class MixinModifier(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): RestartModifiersNode {
        return this as RestartModifiersNode
    }
    override fun getIcon(flags: Int): Icon = RestartIconProvider.MODIFIER
    override fun getNavigationElement(): PsiElement = this
    fun hasMutable(): Boolean {
        for (i in originalElement.children) {
            if (i.text == "mutable" || i.text == "mut") {
                return true
            }
        }
        return false
    }

    override fun getPresentation(): PresentationData {
        return PresentationData("[MODIFIERS]", "", this.getIcon(0), null)
    }

    override fun getChildrenView(): Array<RestartViewElement> {
        return arrayOf()
    }
}

