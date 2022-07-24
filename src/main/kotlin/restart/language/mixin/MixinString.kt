package restart.language.mixin

import restart.language.ast.RestartASTBase
import com.intellij.lang.ASTNode

// PsiReference
open class MixinString(node: ASTNode) : RestartASTBase(node) {
    fun getStringText(): String {
        return this.children.reversed()[2].text
    }
}

