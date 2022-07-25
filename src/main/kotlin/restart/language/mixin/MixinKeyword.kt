package restart.language.mixin

import com.intellij.lang.ASTNode
import restart.language.ast.RestartASTBase

// PsiReference
open class MixinKeyword(node: ASTNode) : RestartASTBase(node) {
    override fun getName(): String? {
        return this.text
    }

//    override fun setName(name: String): PsiElement {
//        return this
//    }

    override fun canNavigate(): Boolean {
        return false
    }
}

