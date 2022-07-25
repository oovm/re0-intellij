package restart.ide.highlight

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.OptionsBundle
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.util.NlsContexts.AttributeDescriptor
import restart.RestartBundle
import java.util.function.Supplier
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default

@Suppress("UnstableApiUsage")
enum class RestartHighlightColor(humanName: Supplier<@AttributeDescriptor String>, default: TextAttributesKey? = null) {
    // 特殊关键词
    KEYWORD(OptionsBundle.messagePointer("options.language.defaults.keyword"), Default.KEYWORD),
    METADATA(OptionsBundle.messagePointer("options.language.defaults.metadata"), Default.METADATA),
    MODIFIER(RestartBundle.messagePointer("color.token.symbol.modifier"), Default.METADATA),

    // 字面量
    NULL(RestartBundle.messagePointer("color.token.null"), Default.KEYWORD),
    BOOLEAN(RestartBundle.messagePointer("color.token.boolean"), Default.KEYWORD),
    BYTE(RestartBundle.messagePointer("color.token.byte"), Default.NUMBER),
    INTEGER(RestartBundle.messagePointer("color.token.integer"), Default.NUMBER),
    DECIMAL(RestartBundle.messagePointer("color.token.decimal"), Default.NUMBER),
    STRING(RestartBundle.messagePointer("color.token.string"), Default.STRING),
    TEXT(RestartBundle.messagePointer("color.token.text"), STRING.textAttributesKey),
    STRING_ESCAPED(RestartBundle.messagePointer("color.token.text"), Default.VALID_STRING_ESCAPE),
    STRING_BAD(RestartBundle.messagePointer("color.token.text"), Default.INVALID_STRING_ESCAPE),

    // 标识符
    IDENTIFIER(OptionsBundle.messagePointer("options.language.defaults.identifier"), Default.IDENTIFIER),
    SYM_PROPERTY(RestartBundle.messagePointer("color.token.symbol.property"), Default.INSTANCE_FIELD),
    SYM_VARIANT(RestartBundle.messagePointer("color.token.symbol.variant"), Default.LOCAL_VARIABLE),
    SYM_HERO(RestartBundle.messagePointer("color.token.symbol.hero"), Default.CONSTANT),
    SYM_ARCHIVE(RestartBundle.messagePointer("color.token.symbol.achievement"), Default.CONSTANT),
    SYM_EVENT(RestartBundle.messagePointer("color.token.symbol.event"), Default.INTERFACE_NAME),
    SYM_TALENT(RestartBundle.messagePointer("color.token.symbol.talent"), Default.CLASS_NAME),
    SYM_CONSTANT(RestartBundle.messagePointer("color.token.symbol.constant"), Default.CONSTANT),
    SYM_FUNCTION(RestartBundle.messagePointer("color.token.symbol.function"), Default.CONSTANT),

    // 标点符号
    OPERATION_SIGN(OptionsBundle.messagePointer("options.language.defaults.operation"), Default.OPERATION_SIGN),
    PARENTHESES(OptionsBundle.messagePointer("options.language.defaults.parentheses"), Default.PARENTHESES),
    BRACKETS(OptionsBundle.messagePointer("options.language.defaults.brackets"), Default.BRACKETS),
    BRACES(OptionsBundle.messagePointer("options.language.defaults.braces"), Default.BRACES),
    DOT(OptionsBundle.messagePointer("options.language.defaults.dot"), Default.DOT),
    STAR(RestartBundle.messagePointer("color.token.default"), Default.KEYWORD),
    COMMA(OptionsBundle.messagePointer("options.language.defaults.comma"), Default.COMMA),
    SET(RestartBundle.messagePointer("color.token.set"), Default.OPERATION_SIGN),
    SEMICOLON(OptionsBundle.messagePointer("options.language.defaults.semicolon"), Default.SEMICOLON),
    OP_NUMBER(RestartBundle.messagePointer("color.token.number.suffix"), Default.METADATA),
    OP_STRING(RestartBundle.messagePointer("color.token.string.prefix"), Default.KEYWORD),

    // 注释
    LINE_COMMENT(OptionsBundle.messagePointer("options.language.defaults.line.comment"), Default.LINE_COMMENT),
    BLOCK_COMMENT(OptionsBundle.messagePointer("options.language.defaults.block.comment"), Default.BLOCK_COMMENT),
    DOC_COMMENT(OptionsBundle.messagePointer("options.language.defaults.doc.markup"), Default.DOC_COMMENT),
    DOC_COMMENT_HINT(OptionsBundle.messagePointer("options.language.defaults.doc.markup"), Default.LINE_COMMENT),
    DOC_COMMENT_WARN(OptionsBundle.messagePointer("options.language.defaults.doc.markup"), Default.LINE_COMMENT),
    DOC_COMMENT_TODO(OptionsBundle.messagePointer("options.language.defaults.doc.markup"), Default.LINE_COMMENT),

    // 错误
    BAD_CHARACTER(
        OptionsBundle.messagePointer("options.java.attribute.descriptor.bad.character"),
        HighlighterColors.BAD_CHARACTER
    ),
    ;

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("voml.lang.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}
