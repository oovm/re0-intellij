package restart.ide.goto

import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension
import com.intellij.lang.Language
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.psi.PsiElement
import restart.RestartLanguage
import restart.ide.file.RestartFileNode
import restart.language.ast.RestartASTBase
import javax.swing.Icon

/// 重写导航栏
class NavigationBarExtension : StructureAwareNavBarModelExtension() {
    override val language: Language = RestartLanguage

    override fun getPresentableText(node: Any?): String? {
        return when (node) {
            is RestartFileNode -> node.name
            is RestartASTBase -> node.name
            else -> null
        }
    }

    override fun getIcon(node: Any?): Icon? {
        return when (node) {
            is RestartFileNode -> node.getIcon(0)
            is RestartASTBase -> node.getIcon(0)
            else -> null
        }
    }
}





