package restart.language.symbol

import com.intellij.model.Pointer
import com.intellij.model.Symbol

enum class RestartSymbolKind {
    RestartClass {

    },
    RestartTrait {
        override fun isTrait(): Boolean {
            return true
        }
    };

    open fun isTrait(): Boolean {
        return false
    }
}