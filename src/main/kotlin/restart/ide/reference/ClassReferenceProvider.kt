package restart.ide.reference

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceService
import com.intellij.psi.PsiReferenceService.Hints
import com.intellij.util.ProcessingContext
import restart.ide.project.RestartProject

class ClassReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        PsiReferenceService.getService().getReferences(element, Hints.NO_HINTS)
//        return RestartProject
//            .getFiles(element.project)
//            .analyzeProperty().values
//            .map { RestartReference(it) }
//            .toTypedArray()
        return arrayOf()
    }

    override fun acceptsHints(element: PsiElement, hints: Hints): Boolean {
        TODO("acceptsHints $element $hints")
    }

    override fun acceptsTarget(target: PsiElement): Boolean {
        TODO("acceptsTarget $target")
    }
}

