package restart.ide.file

import com.intellij.icons.AllIcons
import com.intellij.ide.IconProvider
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import javax.swing.Icon

class RestartIconProvider : IconProvider() {
    override fun getIcon(psiElement: PsiElement, flags: Int): Icon? {
        val file = psiElement.containingFile
        return when {
            file != null && file.name.endsWith(".vk") -> {
                FILE
            }
            else -> {
                null
            }
        }
    }

    companion object {
        val FILE = IconLoader.getIcon("/icons/vk.svg", RestartIconProvider::class.java)
        val NAMESPACE = AllIcons.Nodes.Artifact
        val PROPERTY = AllIcons.Nodes.Property
        val MODIFIER = AllIcons.Nodes.MethodReference
        val CLASS = AllIcons.Nodes.Class
        val TRAIT = AllIcons.Nodes.Interface
    }
}