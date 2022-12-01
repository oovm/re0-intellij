package restart.ide.formatter

import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.tree.TokenSet
import restart.RestartLanguage
import restart.language.psi.RestartTypes.*

data class FormatSpace(val commonSettings: CommonCodeStyleSettings, val spacingBuilder: SpacingBuilder) {
    companion object {
        fun create(settings: CodeStyleSettings): FormatSpace {
            val commonSettings = settings.getCommonSettings(RestartLanguage)
            return FormatSpace(commonSettings, createSpacingBuilder(commonSettings))
        }

        private val remove_space_before = TokenSet.create(
            PARENTHESIS_R,
            BRACKET_R,
            COMMA,
            SEMICOLON
        )
        private val one_space_before = TokenSet.create(
            BRACE_L,
        )
        private val remove_space_after = TokenSet.create(
            PARENTHESIS_L,
            BRACKET_L,
            COLON,
        )
        private val remove_space_newline_after = TokenSet.create(
            DOT,
            OP_MUL,
            OP_SUB,
            OP_PROPORTION,
        )
        private val remove_space_newline_before = TokenSet.create(
            BRACKET_R,
        )

        private val newline_indent_after = TokenSet.create()
        private val binary_operator = TokenSet.create(
            OP_EQ, OP_NE,
            OP_GT, OP_GEQ,
            OP_LT, OP_LEQ,
            OP_MUL, OP_DIV, OP_MOD,
        )

        private fun createSpacingBuilder(commonSettings: CommonCodeStyleSettings): SpacingBuilder {
            val custom = SpacingBuilder(commonSettings)
                // ,
                .after(COMMA).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                // k: v
                .after(COLON).spacing(1, 1, 0, false, 0)
                // k = v
                .around(binary_operator).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)

            return custom
                .before(one_space_before).spacing(1, 1, 0, true, 0)
                .before(remove_space_before).spaceIf(false)
                .after(remove_space_after).spaceIf(false)
                .before(remove_space_newline_before).spacing(0, 0, 0, false, 0)
                .after(remove_space_newline_after).spacing(0, 0, 0, false, 0)
                .after(newline_indent_after).spacing(0, 0, 0, true, 1)
        }
    }
}