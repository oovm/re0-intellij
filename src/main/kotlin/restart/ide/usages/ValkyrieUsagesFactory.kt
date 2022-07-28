package restart.ide.usages

import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.psi.PsiElement

class RestartUsagesFactory : FindUsagesHandlerFactory() {
    override fun canFindUsages(element: PsiElement): Boolean {
        return when (element) {
            is RestartDeclareStatement -> true
            else -> false
        }
    }

    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler? {
        return when (element) {
            is RestartDeclareStatement -> UsagesHandler(element)
            else -> null
        }
    }
}