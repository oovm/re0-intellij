@file:Suppress("UnstableApiUsage")

package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiCompletableReference
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference
import restart.ide.file.RestartIconProvider
import restart.ide.view.RestartViewElement
import restart.language.ast.ASTFactory
import restart.language.ast.RestartASTBase
import restart.language.psi_node.RestartDeclareKeyNode
import restart.language.psi_node.RestartDeclareStatementNode
import restart.language.psi_node.RestartIdentifierNode
import restart.language.symbol.ImportData
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


    override fun getChildrenView(): Array<RestartViewElement> {
        return arrayOf()
    }

    override fun getReference(): PsiReference? {
        return when {
            references.count() != 1 -> null
            else -> references.first()
        }
    }

    override fun getReferences(): Array<PsiReference> {
        return arrayOf()
    }

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
}

