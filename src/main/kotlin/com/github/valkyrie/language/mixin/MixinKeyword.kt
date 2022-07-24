package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.RestartASTBase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiQualifiedNamedElement

// PsiReference
open class MixinKeyword(node: ASTNode) : RestartASTBase(node) {
    override fun getName(): String? {
        return this.text
    }

//    override fun setName(name: String): PsiElement {
//        return this
//    }
}

