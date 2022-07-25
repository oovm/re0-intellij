@file:Suppress("UnstableApiUsage")

package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference
import restart.ide.file.RestartIconProvider
import restart.ide.view.RestartViewElement
import restart.language.ast.ASTFactory
import restart.language.ast.DeclareNode
import restart.language.psi.RestartIdentifier
import restart.language.psi_node.RestartIdentifierNode
import restart.language.psi_node.RestartPropertyStatementNode
import restart.language.symbol.RestartSymbolKind
import javax.swing.Icon

open class MixinProperty(node: ASTNode) : DeclareNode(node),
    PsiNamedElement {
    override fun getOriginalElement(): RestartPropertyStatementNode {
        return this as RestartPropertyStatementNode
    }
    override fun getNameIdentifier(): RestartIdentifierNode {
        return originalElement.identifier as RestartIdentifierNode
    }
    override fun getKind() = RestartSymbolKind.Property
    override fun setName(name: String): PsiElement {
        return ASTFactory(this.project).replaceID(nameIdentifier, name)
    }
    override fun getChildrenView(): Array<RestartViewElement> {
        val views: MutableList<RestartViewElement> = mutableListOf()
//        for (item in PsiTreeUtil.getChildrenOfTypeAsList(containingFile, RestartImportStatementNode::class.java)) {
//            item.addChildrenView(views)
//        }
        return views.toTypedArray()
    }



}


