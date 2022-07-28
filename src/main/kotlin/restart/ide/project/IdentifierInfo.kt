package restart.ide.project

import com.intellij.navigation.NavigationItem
import com.intellij.psi.PsiElement
import restart.language.ast.RestartASTBase
import restart.language.psi_node.RestartExpression
import restart.language.psi_node.RestartIdentifier
import restart.language.psi_node.RestartIdentifierNode
import restart.language.symbol.RestartSymbolKind

class IdentifierInfo {
    val node: RestartASTBase
    val kind: RestartSymbolKind

    constructor(node: RestartASTBase, kind: RestartSymbolKind) {
        this.node = node
        this.kind = kind
    }

    constructor(node: RestartIdentifierNode, kind: RestartSymbolKind) {
        this.node = node
        this.kind = kind
    }

    companion object {
        fun tryFrom(node: RestartExpression, kind: RestartSymbolKind): IdentifierInfo? {
            if (node.children.count() == 1 && node.identifierList.count() == 1) {
                return IdentifierInfo(node.identifierList[0] as RestartASTBase, kind)
            }
            return null
        }
    }
}