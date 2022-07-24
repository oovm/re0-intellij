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
import restart.ide.highlight.RestartHighlightColor as Color

class NodeHighlighter : RestartVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitDeclareStatement(o: RestartDeclareStatement) {
        highlight(o.kwDeclare, Color.KEYWORD)
    }

    override fun visitVariableStatement(o: RestartVariableStatement) {
        highlight(o.kwVariable, Color.KEYWORD)
    }

    override fun visitHeroStatement(o: RestartHeroStatement) {
        highlight(o.kwHero, Color.KEYWORD)
    }

    override fun visitAwardStatement(o: RestartAwardStatement) {
        highlight(o.kwAward, Color.KEYWORD)
    }


    override fun visitEventStatement(o: RestartEventStatement) {
        highlight(o.kwEvent, Color.KEYWORD)
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
            highlight(it.lastChild, Color.SYM_CLASS)
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

    // TODO: real syntax resolve
    override fun visitIdentifier(o: RestartIdentifier) {
        highlightWithText(o)
    }


    override fun visitNumber(o: RestartNumber) {
        o.identifier?.let {
            highlight(it, Color.OP_NUMBER)
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
            }
            else {
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


private fun NodeHighlighter.highlightWithText(o: PsiElement) {
    if (o.text.startsWith("_")) {
        highlight(o, Color.SYM_FIELD)
        return
    }
    else if (o.text.uppercase() == o.text) {
        if (o.text.length == 1) {
            highlight(o, Color.SYM_GENERIC)
        }
        else {
            highlight(o, Color.SYM_CONSTANT)
        }
        return
    }

    when (o.text) {
        "Default", "Debug", "Clone", "Copy", "Serialize", "Deserialize",
        "SemiGroup", "Monoid", "HKT", "Functor", "Shape"
        -> {
            highlight(o, Color.SYM_TRAIT)
        }
        "u8", "u16", "u32", "u64", "u128", "u256",
        "i8", "i16", "i32", "i64", "i128", "i256",
        "int", "bool", "str", "string", "f32", "f64", "char", "byte", "void"
        -> {
            highlight(o, Color.KEYWORD)
        }
        "get", "set", "value", "extends", "self"
        -> {
            highlight(o, Color.KEYWORD)
        }
        "_" -> {
            highlight(o, Color.SYM_GENERIC)
        }
        "map", "or" -> {
            highlight(o, Color.SYM_FUNCTION_SELF)
        }
        "unit", "default" -> {
            highlight(o, Color.SYM_FUNCTION_FREE)
        }
        "Point", "Ellipse", "Circle" -> {
            highlight(o, Color.SYM_CLASS)
        }
        "center", "minor_axis", "major_axis", "radius" -> {
            highlight(o, Color.SYM_FUNCTION_SELF)
        }
        "x", "y", "v" -> {
            highlight(o, Color.SYM_FIELD)
        }
        "Option", "Result", "Current", "Target" -> {
            highlight(o, Color.SYM_CLASS)
        }
        "None", "Some", "Success", "Failure" -> {
            highlight(o, Color.SYM_VARIANT)
        }
        else -> {}
    }
}
