package restart.ide.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import restart.ide.project.RestartProject


class RestartReference(private val caller: PsiElement) : PsiReference {
    override fun getElement(): PsiElement {
        return caller
    }

    override fun getRangeInElement(): TextRange {
        return TextRange(0, caller.textLength)
    }

    override fun resolve(): PsiElement? {
        return RestartProject.getStorage(caller.project)[canonicalText]?.node
    }

    override fun getCanonicalText(): String = caller.text

    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        return caller
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        return caller == element
    }

    override fun isSoft(): Boolean {
        return false
    }
}


