package restart.language.symbol

import com.intellij.model.Pointer
import com.intellij.model.Symbol

enum class ValkyrieSymbolKind {
    ValkyrieClass {

    },
    ValkyrieTrait {
        override fun isTrait(): Boolean {
            return true
        }
    };

    open fun isTrait(): Boolean {
        return false
    }
}