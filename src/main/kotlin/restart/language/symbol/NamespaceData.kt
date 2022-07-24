@file:Suppress("ConvertSecondaryConstructorToPrimary", "MemberVisibilityCanBePrivate", "UnstableApiUsage")

package restart.language.symbol

import restart.language.psi_node.RestartEventStatementNode
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.lang.documentation.DocumentationTarget
import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiCompletableReference
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.navigation.TargetPresentation
import com.intellij.openapi.fileChooser.ex.FileTextFieldUtil.DocumentOwner
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement


class NamespaceData(val nav: RestartEventStatementNode) : Symbol, Pointer<NamespaceData>, PsiSymbolDeclaration {

    override fun createPointer(): Pointer<out NamespaceData> = this
    override fun dereference(): NamespaceData = this
    override fun getSymbol(): Symbol = this
    override fun getDeclaringElement(): PsiElement = nav.nameIdentifier

    override fun getRangeInDeclaringElement(): TextRange = nav.nameIdentifier.textRange
    override fun getAbsoluteRange(): TextRange = nav.textRange

    companion object {

    }
}