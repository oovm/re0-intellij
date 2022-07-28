package restart.ide.project

import com.intellij.navigation.NavigationItem
import com.intellij.psi.PsiElement
import restart.language.ast.RestartASTBase
import restart.language.psi.RestartExpression
import restart.language.psi.RestartIdentifier
import restart.language.psi_node.RestartIdentifierNode
import restart.language.symbol.RestartSymbolKind

class IdentifierInfo(val node: RestartASTBase, val kind: RestartSymbolKind) {
    companion object {
        fun tryFrom(node: RestartExpression, kind: RestartSymbolKind): IdentifierInfo? {
            if (node.children.count() ==1 && node.identifierList.count() == 1) {
                return IdentifierInfo(node.identifierList[0] as RestartASTBase, kind)
            }
            return null
        }
    }
}