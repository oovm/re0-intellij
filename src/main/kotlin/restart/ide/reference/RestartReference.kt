package restart.ide.reference

import com.intellij.navigation.ChooseByNameContributor
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.pom.PsiDeclaredTarget
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference


class RestartReference(private val target: PsiElement) : PsiReference {
    override fun getElement(): PsiElement {
        return target
    }

    override fun getRangeInElement(): TextRange {
        return element.textRange
    }

    override fun resolve(): PsiElement {
        return element
    }

    override fun getCanonicalText(): String {
        return element.text
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        return target
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        return target == element
    }

    override fun isSoft(): Boolean {
        return false
    }
}


