@file:Suppress("UnstableApiUsage")

package restart.language.mixin

import restart.ide.file.RestartIconProvider
import restart.ide.view.RestartViewElement
import restart.language.ast.RestartASTBase
import restart.language.psi_node.RestartDeclareStatementNode
import restart.language.symbol.ImportData
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiCompletableReference
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiReference
import javax.swing.Icon

open class MixinDeclare(node: ASTNode) : RestartASTBase(node) {
    override fun getOriginalElement(): RestartDeclareStatementNode {
        return this as RestartDeclareStatementNode
    }
    override fun getIcon(flags: Int): Icon = RestartIconProvider.IMPORT

    override fun getPresentation(): ItemPresentation? {
        return null
    }

    override fun getChildrenView(): Array<RestartViewElement> {
        return arrayOf()
    }

    override fun getReference(): PsiReference? {
        return when {
            references.count() != 1 -> null
            else -> references.first()
        }
    }

    override fun getReferences(): Array<PsiReference> {
        return  ownReferences.map { it as PsiReference }.toTypedArray()
    }

    override fun getOwnDeclarations(): MutableCollection<out ImportData> {
        return mutableListOf()
    }

    override fun getOwnReferences(): MutableCollection<out PsiCompletableReference> {
        return mutableListOf()
    }
}

