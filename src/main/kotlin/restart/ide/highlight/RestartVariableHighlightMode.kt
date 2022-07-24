package restart.ide.highlight

import restart.language.ast.hasModifier
import restart.language.psi.RestartPatternItem
import restart.language.psi.RestartIdentifier
import restart.ide.highlight.RestartHighlightColor as Color

enum class RestartVariableHighlightMode {
    Local,
    Global,
    Argument,
    Self;

    private fun render(mut: Boolean) = when (this) {
        Local -> if (mut) Color.SYM_LOCAL_MUT else Color.SYM_LOCAL
        Global -> if (mut) Color.SYM_GLOBAL_MUT else Color.SYM_GLOBAL
        Argument -> if (mut) Color.SYM_ARG_MUT else Color.SYM_ARG
        Self -> if (mut) Color.SYM_PROPERTY else Color.SYM_ARG_SELF
    }

    fun highlightPatternItem(
        visitor: NodeHighlighter,
        o: RestartPatternItem,
        force_mut: Boolean = false,
    ) {
        this.highlightMaybeMutable(visitor, o.identifierList, force_mut,true)
        visitor.visitPatternItem(o)
    }

    fun highlightMaybeMutable(
        visitor: NodeHighlighter,
        symbols: List<RestartIdentifier>,
        force_mut: Boolean,
        skip_last: Boolean,
    ) {
        val mutable = when (force_mut) {
            true -> true
            false -> hasModifier(symbols, "mut", skip_last)
        }
        var first = true;
        for (symbol in symbols.reversed()) {
            if (first) {
                first = false
                visitor.highlight(symbol, this.render(mutable))
            } else {
                visitor.highlight(symbol, Color.KEYWORD)
            }
        }
    }
}




