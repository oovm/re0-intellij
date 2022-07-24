package restart.ide.reference

import com.intellij.model.Symbol
import com.intellij.model.psi.ImplicitReferenceProvider
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class RestartImplicitProvider : ImplicitReferenceProvider {
    override fun resolveAsReference(element: PsiElement): MutableCollection<out Symbol> {
        TODO("Not yet implemented $element")
    }
}