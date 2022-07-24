package restart.ide.reference


import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider
import com.intellij.psi.PsiElement

/// 带类型的声明右边的东西
/// a: T
/// def a() -> T
class DeclarationProvider : TypeDeclarationProvider {
    override fun getSymbolTypeDeclarations(element: PsiElement): Array<PsiElement>? {
        return when (element) {
//            is ValkyrieTypeStatementNode -> arrayOf(element.identifier)
//            is ValkyrieClassStatementNode -> findDeclarations(element)
            else -> null
        }
    }

}

