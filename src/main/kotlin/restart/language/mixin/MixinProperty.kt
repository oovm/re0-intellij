@file:Suppress("UnstableApiUsage")

package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceService
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry.getReferencesFromProviders
import restart.ide.file.RestartIconProvider
import restart.ide.project.RestartProject
import restart.ide.reference.RestartReference
import restart.ide.view.RestartViewElement
import restart.language.ast.DeclareNode
import restart.language.psi_node.RestartIdentifierNode
import restart.language.psi_node.RestartPropertyStatementNode
import javax.swing.Icon

open class MixinProperty(node: ASTNode) : DeclareNode(node),
    PsiNameIdentifierOwner{
    override fun getOriginalElement(): RestartPropertyStatementNode {
        return this as RestartPropertyStatementNode
    }

    override fun getNameIdentifier(): RestartIdentifierNode {
        return originalElement.identifier as RestartIdentifierNode
    }

    override fun getIcon(flags: Int): Icon = RestartIconProvider.PROPERTY

    override fun setName(name: String): PsiElement {
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

