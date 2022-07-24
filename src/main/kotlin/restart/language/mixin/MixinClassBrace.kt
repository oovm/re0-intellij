package restart.language.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import restart.language.ast.DeclareNode
import javax.swing.Icon

open class MixinClassBrace(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement {
        TODO("Not yet implemented")
    }


    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Field


    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

