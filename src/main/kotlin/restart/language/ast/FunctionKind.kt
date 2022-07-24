package restart.language.ast

import restart.ide.highlight.RestartHighlightColor

class FunctionKind(
    val isMethod: Boolean = false,
    val isStatic: Boolean = false,
    val isConstructor: Boolean = false,
    val isMutable: Boolean = false
) {
    val color: RestartHighlightColor
        get() = when {
            isMethod -> {
                RestartHighlightColor.SYM_FUNCTION_SELF
            }
            else -> {
                RestartHighlightColor.SYM_FUNCTION_FREE
            }
        }


    companion object {
        val FREE_FUNCTION = FunctionKind()
        val METHOD = FunctionKind(isMethod = true)
        val STATIC_METHOD = FunctionKind(isMethod = true, isStatic = true)
    }
}