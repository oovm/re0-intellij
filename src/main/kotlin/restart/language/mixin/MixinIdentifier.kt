package restart.language.mixin

import com.intellij.lang.ASTNode
import restart.language.ast.RestartASTBase

open class MixinIdentifier(node: ASTNode) : RestartASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }
}
