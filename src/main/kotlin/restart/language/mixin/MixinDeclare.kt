@file:Suppress("UnstableApiUsage")

package restart.language.mixin

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference
import restart.ide.reference.RestartReference
import restart.ide.view.RestartViewElement
import restart.language.ast.ASTFactory
import restart.language.ast.RestartASTBase
import restart.language.psi_node.RestartDeclareKeyNode
import restart.language.psi_node.RestartDeclareStatementNode
import restart.language.psi_node.RestartIdentifierNode
import restart.language.symbol.RestartSymbolKind
import javax.swing.Icon

open class MixinDeclare(node: ASTNode) : RestartASTBase(node), PsiNameIdentifierOwner {
    override fun getOriginalElement(): RestartDeclareStatementNode {
        return this as RestartDeclareStatementNode
    }
    override fun getNameIdentifier(): RestartDeclareKeyNode {
        return originalElement.declareKey as RestartDeclareKeyNode
    }
    override fun getTextOffset(): Int = nameIdentifier.textOffset
    override fun getName(): String = nameIdentifier.name
    override fun setName(name: String): PsiElement {
        return ASTFactory(this).replaceKey(nameIdentifier, name)
    }
    override fun getIcon(flags: Int): Icon = originalElement.kind.icon
    override fun getPresentation(): ItemPresentation {
        return PresentationData(name, null, originalElement.kind.icon, null)
    }
    override fun getChildrenView(): Array<RestartViewElement> {
        val out = mutableListOf<RestartViewElement>()
        for (item in originalElement.declareItemList) {
            out.add(RestartViewElement(item, null))
        }
        return out.toTypedArray()
    }
    override fun getReference(): PsiReference? = null
    override fun getReferences(): Array<PsiReference> {
        val out = mutableListOf<RestartReference>()
        originalElement.modifiers.forEach {
            out.add(RestartReference(it))
        }


        return out.toTypedArray()
    }

}

