package restart.ide.doc

import com.intellij.lang.documentation.DocumentationProvider
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import restart.ide.file.RestartFileNode
import restart.language.ast.DocumentNode
import restart.language.psi.RestartTypes.*
import java.util.function.Consumer


class DocumentationProvider : DocumentationProvider {
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return element?.let { DocumentationRenderer(it, originalElement).onDetail() }
    }

    override fun findDocComment(file: PsiFile, range: TextRange): PsiDocCommentBase? {
        println("findDocComment $file $range")
        return super.findDocComment(file, range)
    }

    override fun collectDocComments(file: PsiFile, sink: Consumer<in PsiDocCommentBase>) {
        if (file !is RestartFileNode) return
        for (leaf in PsiTreeUtil.findChildrenOfType(file, PsiComment::class.java)) {
            DocumentNode.tryBuild(leaf).let {
                if (it != null) {
                    sink.accept(it)
                }
            }
        }
    }

    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        return when (comment) {
            is DocumentNode -> comment.render()
            else -> super.generateRenderedDoc(comment)
        }
    }

    // 按住 Ctrl 后悬浮
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        print("getQuickNavigateInfo: $element, $originalElement")
        return originalElement?.let { this.generateHoverDoc(it, originalElement) }
    }

    // 悬浮
    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String {
        return DocumentationRenderer(element, originalElement).onHover()
    }

    override fun getCustomDocumentationElement(editor: Editor, file: PsiFile, contextElement: PsiElement?, targetOffset: Int): PsiElement? {
        return when (contextElement.elementType) {
            OP_ADD, OP_ADD_ASSIGN, OP_ARROW, OP_ARROW2 -> {
                contextElement
            }

            TokenType.WHITE_SPACE -> {
                null
            }

            else -> {
                null
            }
        }
    }
}