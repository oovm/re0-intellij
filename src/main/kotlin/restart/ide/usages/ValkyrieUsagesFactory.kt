package restart.ide.usages

import restart.language.psi.RestartDeclareStatement
import restart.language.psi.RestartVariableStatement
import restart.language.psi_node.*
import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.psi.PsiElement

class RestartUsagesFactory : FindUsagesHandlerFactory() {
    override fun canFindUsages(element: PsiElement): Boolean {
        return when (element) {
            is RestartDeclareStatement,
            is RestartVariableStatement,
            -> true
            else -> false
        }
    }

    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler? {
        return when (element) {
            is RestartVariableStatement -> RestartUsagesHandler(element)
            else -> null
        }
    }
}