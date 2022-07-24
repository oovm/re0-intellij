@file:Suppress("UnstableApiUsage")

package restart.language.mixin

import restart.ide.file.RestartIconProvider
import restart.ide.view.RestartViewElement
import restart.language.ast.DeclareNode
import restart.language.ast.ViewableNode
import restart.language.ast.addChildrenView
import restart.language.psi_node.RestartVariableStatementNode
import restart.language.symbol.NamespaceData
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.model.psi.*
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

open class MixinProperty(node: ASTNode) : DeclareNode(node),
    PsiNameIdentifierOwner {
    override fun getOriginalElement(): RestartVariableStatementNode {
        return this as RestartVariableStatementNode
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getIcon(flags: Int): Icon {
        TODO("Not yet implemented")
    }


    override fun getChildrenView(): Array<RestartViewElement> {
        val views: MutableList<RestartViewElement> = mutableListOf()
//        for (item in PsiTreeUtil.getChildrenOfTypeAsList(containingFile, RestartImportStatementNode::class.java)) {
//            item.addChildrenView(views)
//        }
        return views.toTypedArray()
    }
}

