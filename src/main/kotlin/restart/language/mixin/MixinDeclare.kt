@file:Suppress("UnstableApiUsage")

package restart.language.mixin

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference
import restart.ide.reference.RestartReference
import restart.ide.view.RestartViewElement
import restart.language.ast.ASTFactory
import restart.language.ast.RestartASTBase
import restart.language.psi.RestartModifiers
import restart.language.psi_node.RestartDeclareItemNode
import restart.language.psi_node.RestartDeclareKeyNode
import restart.language.psi_node.RestartDeclareStatementNode
import restart.language.psi_node.RestartIdentifierNode
import restart.language.symbol.RestartSymbolKind
import javax.swing.Icon

open class MixinDeclare(node: ASTNode) : RestartASTBase(node), PsiNameIdentifierOwner {
    override fun getOriginalElement(): RestartDeclareStatementNode {
        return this as RestartDeclareStatementNode
    }

    override fun getNameIdentifier(): RestartDeclareKeyNode {
        return originalElement.declareKey as RestartDeclareKeyNode
    }

    override fun getTextOffset(): Int = nameIdentifier.textOffset
    override fun getName(): String? = nameIdentifier.name
    override fun setName(name: String): PsiElement {
        return ASTFactory(this).replaceKey(nameIdentifier, name)
    }

    override fun getIcon(flags: Int): Icon = getKind().icon
    override fun getPresentation(): ItemPresentation {
        return PresentationData(name, null, getKind().icon, null)
    }

    override fun getChildrenView(): Array<RestartViewElement> {
        val out = mutableListOf<RestartViewElement>()
        for (item in declareItemList) {
            out.add(RestartViewElement(item, null))
        }
        return out.toTypedArray()
    }

    override fun getReference(): PsiReference? = null

    override fun getReferences(): Array<PsiReference> {
        val out = mutableListOf<RestartReference>()
//        originalElement.modifiers?.let {
//            for (modifier in it.identifierList) {
//                out.add(RestartReference(modifier))
//            }
//        }
        return out.toTypedArray()
    }

    val modifiers: Array<RestartIdentifierNode>
        get() = when (val raw = findChildByClass(RestartModifiers::class.java)) {
            null -> emptyArray()
            else -> {
                raw.identifierList.map {
                    it as RestartIdentifierNode
                }.toTypedArray()
            }

        }

    val declareItemList: Array<RestartDeclareItemNode>
        get() = originalElement
            .declareBlock.declareItemList
            .map { it as RestartDeclareItemNode }
            .toTypedArray()

    fun getKind(): RestartSymbolKind = when (originalElement.kwDeclare.text) {
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
        for (item in originalElement.declareBlock.declareItemList) {
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
        for (item in originalElement.declareBlock.declareItemList) {
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

