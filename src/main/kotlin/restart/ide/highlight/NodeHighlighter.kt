package restart.ide.highlight


import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import restart.ide.file.RestartFileNode
import restart.ide.project.IdentifierStorage
import restart.ide.project.RestartProject
import restart.language.psi.*
import restart.language.psi_node.RestartNumberNode
import restart.ide.highlight.RestartHighlightColor as Color

class NodeHighlighter : RestartVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null
    private var store: MutableMap<String, IdentifierStorage.IdentifierInfo> = mutableMapOf()

    override fun visitDeclareStatement(o: RestartDeclareStatement) {
        highlight(o.kwDeclare, Color.KEYWORD)
    }

    override fun visitPropertyStatement(o: RestartPropertyStatement) {
        highlight(o.kwProperty, Color.KEYWORD)
        highlight(o.identifier, Color.SYM_PROPERTY)
        highlightBraceKey(o.declareBlock, Color.MODIFIER)
    }


    override fun visitHeroStatement(o: RestartHeroStatement) {
        highlight(o.kwHero, Color.KEYWORD)
        highlight(o.identifier, Color.SYM_HERO)
        highlightBraceKey(o.declareBlock, Color.MODIFIER)
    }

    override fun visitTalentStatement(o: RestartTalentStatement) {
        highlight(o.kwTalent, Color.KEYWORD)
        highlight(o.identifier, Color.SYM_AWARD)
        highlightBraceKey(o.declareBlock, Color.MODIFIER)
    }

    override fun visitArchiveStatement(o: RestartArchiveStatement) {
        highlight(o.kwArchive, Color.KEYWORD)
        highlight(o.identifier, Color.SYM_AWARD)
        highlightBraceKey(o.declareBlock, Color.MODIFIER)
    }


    override fun visitEventStatement(o: RestartEventStatement) {
        highlight(o.kwEvent, Color.KEYWORD)
        highlight(o.identifier, Color.SYM_EVENT)
        highlightBraceKey(o.declareBlock, Color.MODIFIER)
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
        val ref = store[o.text]
        ref ?: return
        highlight(o, ref.kind.color)
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

