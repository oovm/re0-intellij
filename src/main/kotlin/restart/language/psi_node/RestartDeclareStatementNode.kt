@file:JvmName("RestartDeclareStatementNode")
@file:JvmMultifileClass

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
        when (visitor) {
            is RestartVisitor -> accept(visitor)
            else -> super.accept(visitor)
        }
    }

    override val declareBlock
        get() = findNotNullChildByClass(RestartDeclareBlock::class.java) as RestartDeclareBlockNode

    override val declareKey
        get() = findNotNullChildByClass(RestartDeclareKey::class.java) as RestartDeclareKeyNode

    override val declareKeyword
        get() = findNotNullChildByClass(RestartKwDeclare::class.java).identifier as RestartIdentifierNode

    override val modifiers
        get() = when (val raw = findChildByClass(RestartModifiers::class.java)) {
            null -> emptyArray()
            else -> raw.identifierList.map { it as RestartIdentifierNode }.toTypedArray()
        }

    override val declareItemList
        get() = declareBlock.declareItemList.map { it as RestartDeclareItemNode }.toTypedArray()

    override val kind: RestartSymbolKind
        get() = when (declareKeyword.text) {
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

    /**
     * @return 返回所有的别名对象
     */
    override val aliases: Array<RestartIdentifierNode>
        get() {
            val out = mutableListOf<RestartIdentifierNode>()
            for (item in declareItemList) {
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

    /**
     * 返回所有的枚举对象
     */
    override val enumerationVariant: Array<RestartIdentifierNode>
        get() {
            val out = mutableListOf<RestartIdentifierNode>()
            for (item in declareItemList) {
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