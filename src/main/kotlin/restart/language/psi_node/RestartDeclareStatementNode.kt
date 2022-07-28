// This is a generated file. Not intended for manual editing.
package restart.language.psi_node

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import restart.language.mixin.MixinDeclare
import restart.language.psi.*
import restart.language.symbol.RestartSymbolKind

class RestartDeclareStatementNode(node: ASTNode) : MixinDeclare(node), RestartDeclareStatement {
    fun accept(visitor: RestartVisitor) {
        visitor.visitDeclareStatement(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is RestartVisitor) accept(visitor) else super.accept(visitor)
    }

    override fun getDeclareBlock() = findNotNullChildByClass(RestartDeclareBlock::class.java)

    override fun getDeclareKey() = findNotNullChildByClass(RestartDeclareKey::class.java)

    override fun getDeclareKeyword() = findNotNullChildByClass(RestartKwDeclare::class.java).identifier as RestartIdentifierNode

    override fun getModifiers() = when (val raw = findChildByClass(RestartModifiers::class.java)) {
        null -> emptyArray()
        else -> raw.identifierList
            .map { it as RestartIdentifierNode }
            .toTypedArray()
    }

    override fun getDeclareItemList() = declareBlock.declareItemList
        .map { it as RestartDeclareItemNode }
        .toTypedArray()




    fun getKind(): RestartSymbolKind = when (originalElement.declareKeyword.text) {
        "award", "成就" -> {
            RestartSymbolKind.Achievement
        }

        "variable", "属性", "内置", "设定" -> {
            RestartSymbolKind.Property
        }

        "event", "事件" -> {
            RestartSymbolKind.Event
        }

        "character", "人物", "英雄" -> {
            RestartSymbolKind.Achievement
        }

        "talent", "skill", "装备", "物品", "道具", "天赋", "技能", "特质" -> {
            RestartSymbolKind.Talent
        }

        else -> {
            RestartSymbolKind.Unknown
        }
    }

    fun getAlias(): Array<RestartIdentifierNode> {
        val out = mutableListOf<RestartIdentifierNode>()
        for (item in originalElement.getDeclareItemList()) {
            when (item.declareKey.text) {
                "别称", "alias" -> {
                    item.expressionList.forEach {
                        if (it.identifierList.size == 1) {
                            out.add(it.identifierList.first() as RestartIdentifierNode)
                        }
                    }
                    break
                }
            }
        }
        return out.toTypedArray()
    }

    fun getEnumerationVariant(): Array<RestartIdentifierNode> {
        val out = mutableListOf<RestartIdentifierNode>()
        for (item in originalElement.getDeclareItemList()) {
            when (item.declareKey.text) {
                "枚举", "enum" -> {
                    item.expressionList.forEach {
                        if (it.identifierList.size == 1) {
                            out.add(it.identifierList.first() as RestartIdentifierNode)
                        }
                    }
                    break
                }
            }
        }
        return out.toTypedArray()
    }
}