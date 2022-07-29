package restart.ide.doc.builtin

import io.ktor.util.*
import restart.ide.highlight.RestartHighlightColor.*

private const val indent = "&nbsp;&nbsp;&nbsp;&nbsp;"

object DocumentationBuiltinKeywords {
    fun talentHover(): String = """
        <p>${keyword("天赋")}
            ${keyword("函数")}: ${function("拥有")}, ${function("没有")}, ${function("得到")}, ${function("失去")}
        </p>
        <p>天赋不可重复, 同名天赋只能得到一个</p>
    """.trimIndent()
    fun talentDetail(): String = """
        <p>${keyword("天赋")}</p>
        <div>
            <p>${function("拥有")}(${item("天赋1")}, ${item("天赋2")})</p>
            <p>${indent}判定是否拥有某些天赋, 全都有返回真</p>
            <p>${function("拥有")}(${item("天赋1")})${op("或")}${function("拥有")}(${item("天赋2")})</p>
            <p>${indent}判定是否拥有某些天赋, 有一个即可</p>
        </div>
        <div>
            <p>${function("没有")}(${item("天赋1")}, ${item("天赋2")})</p>
            <p>${indent}判定是否没有这些天赋, 全都没有返回真</p>
            <p>${function("没有")}(${item("天赋1")})${op("或")}${function("没有")}(${item("天赋2")})</p>
            <p>${indent}判定是否没有这些天赋, 有一个成立即可</p>
        </div>
    """.trimIndent()

    private fun op(s: String): String {
        return "<span color=\"${OPERATION_SIGN}\">${s.escapeHTML()}</span>"
    }

    private fun item(s: String): String {
        return "<span color=\"${SYM_TALENT}\">${s.escapeHTML()}</span>"
    }

    private fun keyword(s: String): String {
       return "<span color=\"$KEYWORD\">${s.escapeHTML()}</span>"
    }
    private fun function(s: String): String {
        return "<span color=\"${SYM_FUNCTION}\">${s.escapeHTML()}</span>"
    }
}