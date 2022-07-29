package restart.ide.highlight


import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import restart.ide.file.RestartFileNode
import restart.ide.project.IdentifierInfo
import restart.ide.project.RestartProject
import restart.language.psi_node.*
import restart.ide.highlight.RestartHighlightColor as Color

class NodeHighlighter : RestartVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null
    private var store: MutableMap<String, IdentifierInfo> = mutableMapOf()

    override fun visitDeclareStatement(o: RestartDeclareStatement) {
        highlight(o.declareKeyword, Color.KEYWORD)
        highlight(o.declareKey, o.kind.color)
        highlightMaybeEnum(o)
        highlightBraceKey(o.declareBlock, Color.MODIFIER)
    }

    private fun highlightMaybeEnum(o: RestartDeclareStatement) {
        o.aliases.forEach { highlight(it, Color.SYM_PROPERTY) }
        o.enumerationVariant.forEach { highlight(it, Color.SYM_VARIANT) }
    }

    override fun visitModifiers(o: RestartModifiers) {
        o.identifierList.forEach {
            highlight(it, Color.MODIFIER)
        }
    }

    override fun visitNumber(o: RestartNumber) {
        val node = o as RestartNumberNode
        node.identifier?.let {
            highlight(it, Color.MODIFIER)
        }
    }

    override fun visitString(o: RestartString) {
        o.identifier?.let {
            highlight(it, Color.OP_STRING)
        }
    }

    override fun visitBoolean(o: RestartBoolean) {
        highlight(o, Color.KEYWORD)
    }

    override fun visitIdentifier(o: RestartIdentifier) {
        o as RestartIdentifierNode;
        if (!o.shouldResolve()) {
            return
        }
        if (o.isKeywordName()) {
            highlight(o, Color.KEYWORD);
            return
        }
        val ref = store[o.text]
        when {
            ref != null -> highlight(o, ref.kind.color)
            else -> return
        }
    }

    // =================================================================================================================

    fun highlight(element: PsiElement?, color: Color) {
        if (element == null) return
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)
        infoHolder?.add(builder.create())
    }


    override fun analyze(file: PsiFile, updateWholeFile: Boolean, holder: HighlightInfoHolder, action: Runnable): Boolean {
        store = RestartProject.getStorage(file.project)
        infoHolder = holder
        action.run()
        return true
    }

    override fun clone(): HighlightVisitor = NodeHighlighter()

    override fun suitableForFile(file: PsiFile): Boolean = file is RestartFileNode

    override fun visit(element: PsiElement) = element.accept(this)
}

private fun NodeHighlighter.highlightBraceKey(o: RestartDeclareBlock?, color: Color) {
    if (o == null) return
    for (i in o.declareItemList) {
        highlight(i.declareKey, color)
    }
}

