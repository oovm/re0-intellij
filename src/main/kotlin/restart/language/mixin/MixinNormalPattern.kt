package restart.language.mixin

import restart.ide.reference.ValkyrieReference
import restart.language.ast.RestartASTBase
import restart.language.psi.ValkyrieIdentifier
import restart.language.psi.ValkyrieNormalPattern
import restart.language.psi.ValkyriePatternPair
import com.intellij.lang.ASTNode
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference


@Suppress("UnstableApiUsage")
abstract class MixinNormalPattern(node: ASTNode) : RestartASTBase(node),
    ValkyrieNormalPattern {

    override fun getReference(): PsiReference? {
        return ValkyrieReference(node.psi.parent)
    }

    override fun getReferences(): Array<PsiReference> {
        val out = mutableListOf<PsiReference>()
        for (child in identifierList) {
            if (child is ValkyrieIdentifier) {
                out.add(ValkyrieReference(child))
            }
        }
        return out.toTypedArray()
    }

    override fun getOwnReferences(): MutableCollection<out PsiSymbolReference> {
        val out = mutableListOf<PsiSymbolReference>()
        for (child in identifierList) {
            if (child is ValkyrieIdentifier) {
                out.add(Modifier(child))
            }
        }
        return out
    }

    override fun getOwnDeclarations(): MutableCollection<out PsiSymbolDeclaration> {
        val out = mutableListOf<PsiSymbolDeclaration>()
//        for (child in patternItemList) {
//            if (child is ValkyriePatternPair) {
//                out.add(Pattern(child))
//            }
//        }
        return out
    }

    class Modifier(private var target: ValkyrieIdentifier) : PsiSymbolReference {
        override fun getElement(): PsiElement {
            return target
        }

        override fun getRangeInElement(): TextRange {
            return element.textRange
        }

        override fun resolveReference(): MutableCollection<out Symbol> {
            TODO("Not yet implemented")
        }
    }

    class Pattern(private var target: ValkyriePatternPair) : PsiSymbolDeclaration {
        override fun getDeclaringElement(): PsiElement {
            return target
        }

        override fun getRangeInDeclaringElement(): TextRange {
            return declaringElement.textRange
        }

        override fun getSymbol(): Symbol {
            TODO("Not yet implemented")
        }
    }
}

