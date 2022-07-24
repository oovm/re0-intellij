package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import restart.ide.reference.RestartReference
import restart.language.ast.RestartASTBase
import restart.language.psi.RestartIdentifier
import restart.language.psi.RestartNormalPattern


@Suppress("UnstableApiUsage")
abstract class MixinNormalPattern(node: ASTNode) : RestartASTBase(node),
    RestartNormalPattern {

    override fun getReference(): PsiReference? {
        return RestartReference(node.psi.parent)
    }

    override fun getReferences(): Array<PsiReference> {
        val out = mutableListOf<PsiReference>()
        for (child in identifierList) {
            if (child is RestartIdentifier) {
                out.add(RestartReference(child))
            }
        }
        return out.toTypedArray()
    }

    override fun getOwnReferences(): MutableCollection<out PsiSymbolReference> {
        val out = mutableListOf<PsiSymbolReference>()
        for (child in identifierList) {
            if (child is RestartIdentifier) {
                out.add(Modifier(child))
            }
        }
        return out
    }

    override fun getOwnDeclarations(): MutableCollection<out PsiSymbolDeclaration> {
        val out = mutableListOf<PsiSymbolDeclaration>()
//        for (child in patternItemList) {
//            if (child is RestartPatternPair) {
//                out.add(Pattern(child))
//            }
//        }
        return out
    }

    class Modifier(private var target: RestartIdentifier) : PsiSymbolReference {
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
}

