package restart.language.mixin

import com.intellij.lang.ASTNode
import restart.language.ast.RestartASTBase

// PsiReference
open class MixinNumber(node: ASTNode) : RestartASTBase(node) {
    fun getStringText(): String {
        return this.children.reversed()[2].text
    }
}

