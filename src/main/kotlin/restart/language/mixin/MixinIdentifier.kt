package restart.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.navigation.ChooseByNameContributor
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiReference
import restart.ide.project.RestartProject
import restart.ide.reference.RestartReference
import restart.language.ast.RestartASTBase

open class MixinIdentifier(node: ASTNode) : RestartASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }

    override fun getReference(): PsiReference? {
        return references.firstOrNull()
    }

    override fun getReferences(): Array<RestartReference> {
        val out = RestartProject.getFiles(this.project).analyzeProperty().values.map { RestartReference(this) }.toTypedArray()
        print(out)
        return out
    }
}

