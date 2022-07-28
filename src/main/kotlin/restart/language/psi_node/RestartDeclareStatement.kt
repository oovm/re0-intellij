@file:JvmName("RestartDeclareStatement")

package restart.language.psi_node

import com.intellij.psi.PsiElement
import restart.language.symbol.RestartSymbolKind

interface RestartDeclareStatement : PsiElement {
    val declareKeyword: RestartIdentifierNode
    val declareKey: RestartDeclareKeyNode
    val kind: RestartSymbolKind
    val modifiers: Array<RestartIdentifierNode>
    val declareBlock: RestartDeclareBlockNode
    val declareItemList: Array<RestartDeclareItemNode>
    val enumerationVariant: Array<RestartIdentifierNode>
    val aliases: Array<RestartIdentifierNode>
}