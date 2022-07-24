package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.RestartASTBase
import com.intellij.lang.ASTNode

open class MixinIdentifier(node: ASTNode) : RestartASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }
}
