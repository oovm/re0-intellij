package restart.language.symbol

enum class RestartSymbolKind {
    RestartClass,
    RestartTrait {
        override fun isTrait(): Boolean {
            return true
        }
    };

    open fun isTrait(): Boolean {
        return false
    }
}