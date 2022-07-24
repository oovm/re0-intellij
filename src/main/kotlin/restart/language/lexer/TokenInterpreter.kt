@file:OptIn(ExperimentalStdlibApi::class)

package restart.language.lexer

import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType
import restart.language.lexer.LexerContext.Coding
import restart.language.psi.RestartTypes

private val OPERATORS = """(?x)
      [.]{1,3}
    | [{}\[\]()]
    | [,;$^]
    | @[*!?@]?
    # start with < >
    | >= | ≥ | ⩾ | > | \b大于\b | \b大于等于\b
    | <= | ≤ | ⩽ | < | \b小于\b | \b小于等于\b
    # start with :
    | ∷ | :: | :> | :
    # start with -
    | -= | -> | ⟶ | -{1,2}
    # start with ~
    | ~> | ~
    # start with +
    | [+]= | [+]> | [+]{1,2}
    # start with *
    | [*]=?
    # start with / or % or ÷
    | /=?
    | ÷=?
    | %=?
    # start with &
    | &{1,2} | \b且\b
    | [|]{1,2} | \b或\b
    | ⊻=? | ⊼=? | ⊽=?
    # start with !
    | != | ≠ | !
    # start with ?
    | [?]
    # start with =
    | => | ⇒
    | === | == | =
    # unicode
    | [∈∊∉⊑⋢⨳∀∁∂∃∄¬±√∛∜⊹⋗]
    | [⟦⟧⁅⁆⟬⟭]
    #
    """.toRegex()
private val STRINGS = """(?x)
      (?<s1>"{3,}|'{3,})(?<t1>[^\00]*?)(?<e1>\k<s1>)
    | (?<s2>')(?<t2>[^']*)(?<e2>')
    | (?<s3>")(?<t3>[^"]*)(?<e3>")
    | (?<s4>«)(?<t4>[^»]*)(?<e4>»)
    | (?<s5>‘)(?<t5>[^’]*)(?<e5>’)
    | (?<s6>“)(?<t6>[^”]*)(?<e6>”)
    """.toRegex()

@Suppress("MemberVisibilityCanBePrivate")
class TokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int) {
    var stack: MutableList<StackItem> = mutableListOf()

    var contextStack: MutableList<LexerContext> = mutableListOf()

    val context: LexerContext
        get() = contextStack.lastOrNull() ?: Coding

    fun interpreter(): Array<StackItem> {
        while (startOffset < endOffset) {
            if (matchesWhitespace()) continue
            if (codeComment()) continue
            if (codeString()) continue
            if (codeNumber()) continue
            if (codePunctuations()) continue
            if (codeKeywords()) continue
            if (codeIdentifier()) continue
            break
        }
        checkRest()
        return stack.toTypedArray()
    }

    private fun matchesWhitespace(): Boolean {
        val r = tryMatch("\\s+".toRegex()) ?: return false
        pushToken(WHITE_SPACE, r)
        return true
    }

    private fun codeComment(): Boolean {
        val comment = """(/{2,})([^\r\n]*)""".toRegex()
        val r = tryMatch(comment) ?: return false
        pushToken(RestartTypes.COMMENT_SL, r.groups[1]!!)
        pushToken(RestartTypes.COMMENT_TEXT, r.groups[2]!!)
        return true
    }

    private fun codeString(): Boolean {
        val r = tryMatch(STRINGS) ?: return false
        val slots = arrayOf(
            arrayOf("s1", "t1", "e1"),
            arrayOf("s2", "t2", "e2"),
            arrayOf("s3", "t3", "e3"),
            arrayOf("s4", "t4", "e4"),
            arrayOf("s5", "t5", "e5"),
            arrayOf("s6", "t6", "e6")
        )
        for (slot in slots) {
            val start = r.groups[slot[0]]
            val text = r.groups[slot[1]]
            val end = r.groups[slot[2]]
            if (text != null) {
                pushToken(RestartTypes.STRING_START, start!!)
                pushToken(RestartTypes.STRING_TEXT, text)
                pushToken(RestartTypes.STRING_END, end!!)
                break
            }

        }
        return true
    }

    private fun codeNumber(): Boolean {
        val numbers = """(?x)
              (?<s1>[1-9]\d*[.]\d+)
            | (?<s2>0[.]\d+)
            | (?<s3>0|[1-9]\d*)
            | (?<s4>0[a-zA-Z][\da-zA-Z]+)
        """.toRegex()
        val r = tryMatch(numbers) ?: return false
        when {
            r.groups["s1"] != null -> {
                pushToken(RestartTypes.DECIMAL, r)
            }

            r.groups["s2"] != null -> {
                pushToken(RestartTypes.DECIMAL, r)
            }

            r.groups["s3"] != null -> {
                pushToken(RestartTypes.INTEGER, r)
            }

            r.groups["s4"] != null -> {
                pushToken(RestartTypes.BYTE, r)
            }
        }
        return true
    }

    private fun codeKeywords(): Boolean {
        val keywords = """(?x)
              \b(?<if>if|若|如果)\b
            | \b(?<when>当)\b
            | \b(?<else>else|否则)\b
            | \b(?<elseif>ef|或者|又若)\b
        """.toRegex()
        val r = tryMatch(keywords) ?: return false
        when {
            r.groups["if"] != null -> {
                pushToken(RestartTypes.KW_IF, r)
            }

            r.groups["elseif"] != null -> {
                pushToken(RestartTypes.KW_ELSE_IF, r)
            }

            r.groups["else"] != null -> {
                pushToken(RestartTypes.KW_IF, r)
            }

            r.groups["when"] != null -> {
                pushToken(RestartTypes.DECIMAL, r)
            }
        }
        return true
    }

    private fun codeIdentifier(): Boolean {
        val xid = """(?x)
            [\p{L}_][\p{L}_\d]*
          | (`)((?:[^`\\]|\\.)*)(\1)
        """.toRegex()
        val r = tryMatch(xid) ?: return false
        when {
            lastIs(RestartTypes.DECIMAL, RestartTypes.INTEGER, RestartTypes.BYTE, skipWS = false) -> {
                pushToken(RestartTypes.NUMBER_SUFFIX, r)
            }

            else -> {
                pushToken(RestartTypes.SYMBOL_XID, r)
            }
        }
        return true
    }

    private fun codePunctuations(): Boolean {
        val r = tryMatch(OPERATORS) ?: return false
        when (r.value) {
            // DOT
            ":=", "≔" -> pushToken(RestartTypes.OP_BIND, r)
            "->", "⟶" -> pushToken(RestartTypes.OP_ARROW, r)
            "=>", "⇒" -> pushToken(RestartTypes.OP_ARROW2, r)
            "==", "≡" -> pushToken(RestartTypes.OP_EQ, r)
            "=" -> pushToken(RestartTypes.OP_SET, r)
            "." -> {
                pushToken(RestartTypes.DOT, r)
            }

            ":", "∶" -> {
                pushToken(RestartTypes.COLON, r)
            }

            "::", "∷" -> {
                pushToken(RestartTypes.OP_PROPORTION, r)

            }

            ".." -> pushToken(RestartTypes.DOT, r)
            "..." -> pushToken(RestartTypes.DOT, r)
            ";" -> {
                pushToken(RestartTypes.SEMICOLON, r)
            }

            "," -> pushToken(RestartTypes.COMMA, r)
            // start with +
            "++" -> pushToken(RestartTypes.OP_INC, r)
            "+=" -> pushToken(RestartTypes.OP_ADD_ASSIGN, r)
            "+" -> pushToken(RestartTypes.OP_ADD, r)
            // start with -
            "--" -> pushToken(RestartTypes.OP_DEC, r)
            "-=" -> pushToken(RestartTypes.OP_SUB_ASSIGN, r)
            "-" -> pushToken(RestartTypes.OP_SUB, r)
            // start with *
            "*=" -> pushToken(RestartTypes.OP_MUL_ASSIGN, r)
            "*" -> pushToken(RestartTypes.OP_MUL, r)
            // start with /
            "/=" -> pushToken(RestartTypes.OP_DIV_ASSIGN, r)
            "/" -> pushToken(RestartTypes.OP_DIV, r)
            // start with &
            "&", "&&", "且" -> pushToken(RestartTypes.OP_AND, r)
            "|", "||", "或" -> pushToken(RestartTypes.OP_OR, r)
            //
            // start with !
            "!!" -> pushToken(RestartTypes.OP_NE, r)
            "!=" -> pushToken(RestartTypes.OP_NE, r)
            "!" -> pushToken(RestartTypes.OP_NOT, r)
            "^" -> pushToken(RestartTypes.OP_POW, r)
            // start with >
            ">=", "≥", "⩾", "大于等于" -> pushToken(RestartTypes.OP_GEQ, r)
            "<=", "≤", "⩽", "小于等于" -> pushToken(RestartTypes.OP_LEQ, r)
            ">", "大于" -> pushToken(RestartTypes.OP_GT, r)
            "<", "小于" -> pushToken(RestartTypes.OP_LT, r)
            // surround with ( )
            "(" -> pushToken(RestartTypes.PARENTHESIS_L, r)
            ")" -> pushToken(RestartTypes.PARENTHESIS_R, r)
            "[" -> pushToken(RestartTypes.BRACKET_L, r)
            "]" -> pushToken(RestartTypes.BRACKET_R, r)
            "{" -> pushToken(RestartTypes.BRACE_L, r)
            "}" -> pushToken(RestartTypes.BRACE_R, r)

            "∅", "⤇", "|=>", "⤃", "!=>" -> {
                pushToken(RestartTypes.OP_EMPTY, r)
            }

            else -> pushToken(BAD_CHARACTER, r)
        }
        return true
    }


    private fun checkRest() {
        if (startOffset < endOffset) {
            pushToken(RestartTypes.COMMENT_TEXT, startOffset, endOffset)
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun tryMatch(pattern: Regex): MatchResult? {
        val r = pattern.matchAt(buffer, startOffset)
        return when {
            r == null -> null
            r.value.isEmpty() -> null
            else -> r
        }
    }

    fun pushToken(token: IElementType, startOffset: Int, endOffset: Int): Boolean {
        stack.add(StackItem(token, startOffset, endOffset, context))
        this.startOffset = endOffset + 1
        return true
    }

    fun pushToken(token: IElementType, match: MatchResult): Boolean {
        stack.add(StackItem(token, match.range.first, match.range.last + 1, context))
        startOffset = match.range.last + 1
        return true
    }

    fun pushToken(token: IElementType, match: MatchGroup): Boolean {
        stack.add(StackItem(token, match.range.first, match.range.last + 1, context))
        startOffset = match.range.last + 1
        return true
    }
}

private fun TokenInterpreter.resetToken(token: IElementType) {
    for (item in stack.asReversed()) {
        when {
            item.canSkip() -> continue
            else -> {
                item.token = token
                break
            }
        }
    }
}

private fun TokenInterpreter.resetContext(context: LexerContext) {
    contextStack.removeLastOrNull()
    contextStack.add(context)
}

private fun TokenInterpreter.enterContext(context: LexerContext) {
    contextStack.add(context)
}

private fun TokenInterpreter.endContext() {
    contextStack.removeLastOrNull()
}

private fun TokenInterpreter.contextIs(vararg check: LexerContext): Boolean {
    for (c in check) {
        if (context == c) {
            return true
        }
    }
    return false
}


private fun TokenInterpreter.lastIs(vararg token: IElementType, skipWS: Boolean = true): Boolean {
    for (item in stack.reversed()) {
        if (item.canSkip()) {
            when {
                skipWS -> continue
                else -> return false
            }
        }
        if (item.tokenIs(*token)) return true
    }
    return false
}

private fun TokenInterpreter.lastNot(vararg token: IElementType, skipWS: Boolean = true): Boolean {
    for (item in stack.reversed()) {
        if (item.tokenIs(WHITE_SPACE, RestartTypes.COMMENT_SL, RestartTypes.COMMENT_TEXT)) {
            when {
                skipWS -> continue
                else -> return false
            }
        }
        if (item.tokenIs(*token)) return false
    }
    return true
}
