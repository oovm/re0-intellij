package restart.language.symbol

import restart.ide.file.RestartIconProvider
import restart.ide.highlight.RestartHighlightColor

enum class RestartSymbolKind {
    Unknown,
    Property,
    Enumerate,
    Talent,
    Event
    ;

    val color
        get() = when (this) {
            Unknown -> RestartHighlightColor.IDENTIFIER
            Property -> RestartHighlightColor.SYM_PROPERTY
            Talent -> RestartHighlightColor.SYM_TALENT
            Event -> RestartHighlightColor.SYM_EVENT
            Enumerate -> RestartHighlightColor.SYM_VARIANT
        }

    val icon
        get() = when (this) {
            Unknown -> RestartIconProvider.EVENT
            Property -> RestartIconProvider.PROPERTY
            Talent -> RestartIconProvider.EVENT
            Event -> RestartIconProvider.EVENT
            Enumerate -> RestartIconProvider.EVENT
        }
}