package restart.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import restart.language.ast.ViewableNode
import javax.swing.Icon

open class MixinClassTuple(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Field

    override fun getNavigationElement(): PsiElement = originalElement

    fun getIndexInParent(): Int {
        return this.parent.children.indexOf(this)
    }
}

