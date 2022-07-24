package restart.language.mixin

import restart.language.ast.RestartASTBase
import com.intellij.lang.ASTNode

open class MixinIdentifier(node: ASTNode) : RestartASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }
}
