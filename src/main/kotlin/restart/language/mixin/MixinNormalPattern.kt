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


}

