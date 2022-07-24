package restart.ide.view

import restart.ide.file.ValkyrieFileNode
import restart.language.ast.RestartASTBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

class ValkyrieViewElement(private val self: NavigatablePsiElement, var view: ItemPresentation? = null) :
    StructureViewTreeElement,
    SortableTreeElement {
    override fun getValue(): Any = self

    override fun navigate(requestFocus: Boolean) = self.navigate(requestFocus)

    override fun canNavigate(): Boolean = self.canNavigate()

    override fun canNavigateToSource(): Boolean = self.canNavigateToSource()

    override fun getAlphaSortKey(): String = self.name ?: ""

    override fun getPresentation(): ItemPresentation = when {
        view != null -> view!!
        self.presentation != null -> self.presentation!!
        else -> PresentationData()
    }

    override fun getChildren(): Array<out TreeElement> = when (self) {
        is ValkyrieFileNode -> self.getChildrenView()
        is RestartASTBase -> self.getChildrenView()
        else -> arrayOf()
    }

    // TODO: return object
    fun getVisibility(): Boolean = true
}