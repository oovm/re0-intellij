package restart.ide.project

import restart.language.psi.RestartExpression
import restart.language.psi_node.RestartIdentifierNode
import restart.language.symbol.RestartSymbolKind

class IdentifierInfo(val node: RestartIdentifierNode, val kind: RestartSymbolKind) {
    companion object {
        fun tryFrom(node: RestartExpression, kind: RestartSymbolKind): IdentifierInfo? {
            if (node.children.count() ==1 && node.identifierList.count() == 1) {
                return IdentifierInfo(node.identifierList[0] as RestartIdentifierNode, kind)
            }
            return null
        }
    }
}