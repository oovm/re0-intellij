package restart.language.ast


import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationRequest
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference
import javax.swing.Icon

/// 一定是可以 view 的节点
/// PsiSymbolDeclarationProvider,
abstract class DeclareNode(node: ASTNode) : RestartASTBase(node),
    PsiNameIdentifierOwner {
    abstract override fun getOriginalElement(): PsiElement
    abstract override fun getNameIdentifier(): PsiElement
    override fun getIcon(flags: Int): Icon = getKind().icon
    override fun getElementIcon(flags: Int): Icon = this.getIcon(flags)
    override fun getName(): String = this.nameIdentifier.text
    override fun getNavigationElement(): PsiElement = this.nameIdentifier
    override fun getTextOffset(): Int = this.nameIdentifier.textOffset
    override fun getPresentation(): ItemPresentation {
        return PresentationData(this.name, "", this.getIcon(0), null)
    }
    override fun canNavigate(): Boolean {
        return true
    }
    override fun getReference(): PsiReference? {
        return null
    }

    override fun getReferences(): Array<PsiReference> {
        return arrayOf()
    }
}

