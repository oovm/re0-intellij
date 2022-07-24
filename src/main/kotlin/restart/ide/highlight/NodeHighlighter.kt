package restart.ide.highlight


import restart.ide.file.RestartFileNode
import restart.language.ast.isMutable
import restart.language.psi.*
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import restart.language.ast.identifier
import restart.ide.highlight.RestartHighlightColor as Color

class NodeHighlighter : RestartVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

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

    override fun visitNormalPattern(o: RestartNormalPattern) {
        val mut = o.isMutable();
        val mode = RestartVariableHighlightMode.Local;
        highlightSymbolList(o.identifierList, Color.KEYWORD)
//        o.patternItemList.forEach {
//            mode.highlightPatternItem(this, it, mut)
//        }
//        o.patternPairList.forEach {
//            mode.highlightPatternPair(this, it, mut)
//        }
    }

    override fun visitCasePattern(o: RestartCasePattern) {
        visitCasePattern(o, RestartVariableHighlightMode.Local, false)
    }

    private fun visitCasePattern(o: RestartCasePattern, mode: RestartVariableHighlightMode, force_mut: Boolean) {
        o.namepath?.let {
            highlight(it.lastChild, Color.SYM_EVENT)
        }
//        o.patternTuple?.let {
//            this.visitPatternTuple(it, mode, force_mut)
//        }
        super.visitCasePattern(o)
    }


    override fun visitModifiers(o: RestartModifiers) {
        o.identifierList.forEach {
            highlight(it, Color.MODIFIER)
        }
    }

    override fun visitNumber(o: RestartNumber) {
        o.identifier?.let {
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

    // =================================================================================================================

    private fun highlightSymbolList(
        symbols: List<RestartIdentifier>,
        last: Color,
        rest: Color = Color.KEYWORD,
    ) {
        var first = true;
        for (symbol in symbols.reversed()) {
            if (first) {
                first = false
                highlight(symbol, last)
            } else {
                highlight(symbol, rest)
            }
        }
    }

    fun highlight(element: PsiElement?, color: Color) {
        if (element == null) return
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }


    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable,
    ): Boolean {
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

