package restart.ide.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import restart.RestartBundle
import restart.RestartLanguage
import restart.ide.view.RestartViewElement

/// RestartFile 是个 PsiElement
class RestartFileNode(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, RestartLanguage) {
    override fun getFileType(): FileType = RestartFileType

    override fun toString(): String = RestartBundle.message("action.create_file")

    fun getChildrenView(): Array<TreeElement> {
        return PsiTreeUtil
            .getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)
            .filter { it.presentation != null }
            .map { RestartViewElement(it) }
            .toTypedArray()
    }

    fun isIndexFile(): Boolean {
        return this.name == "index.vk"
    }
}