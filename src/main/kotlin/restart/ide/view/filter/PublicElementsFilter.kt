package restart.ide.view.filter


import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import restart.RestartBundle
import restart.ide.view.RestartViewElement


object PublicElementsFilter : Filter {

    override fun getName() = "view.PublicElementsFilter"

    override fun isReverted() = true
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        RestartBundle.message(name),
        null,
        AllIcons.Nodes.Public
    )

    override fun isVisible(treeNode: TreeElement): Boolean {
        return (treeNode as? RestartViewElement)?.getVisibility() ?: true
    }
}
