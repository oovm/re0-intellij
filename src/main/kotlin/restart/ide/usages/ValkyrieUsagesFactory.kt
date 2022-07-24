package restart.ide.usages

import restart.language.psi.RestartDeclareStatement
import restart.language.psi_node.*
import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.psi.PsiElement
import restart.language.psi.RestartTalentStatement

class RestartUsagesFactory : FindUsagesHandlerFactory() {
    override fun canFindUsages(element: PsiElement): Boolean {
        return when (element) {
            is RestartDeclareStatement,
            is RestartTalentStatement,
            -> true
            else -> false
        }
    }

    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler? {
        return when (element) {
            is RestartDeclareStatement -> RestartUsagesHandler(element)
            else -> null
        }
    }
}