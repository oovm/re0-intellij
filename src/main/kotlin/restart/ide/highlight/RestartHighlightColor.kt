package restart.ide.highlight

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.OptionsBundle
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.util.NlsContexts.AttributeDescriptor
import java.util.function.Supplier
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default
import restart.RestartBundle;

@Suppress("UnstableApiUsage")
enum class RestartHighlightColor(humanName: Supplier<@AttributeDescriptor String>, default: TextAttributesKey? = null) {
    // 特殊关键词
    KEYWORD(OptionsBundle.messagePointer("options.language.defaults.keyword"), Default.KEYWORD),
    METADATA(OptionsBundle.messagePointer("options.language.defaults.meta.data"), Default.METADATA),
    MODIFIER(RestartBundle.messagePointer("Restart.highlight.modifier"), Default.METADATA),

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
    SYM_HERO(RestartBundle.messagePointer("color.token.symbol.trait"), Default.CLASS_REFERENCE),
    SYM_GENERIC(RestartBundle.messagePointer("color.token.symbol.trait"), Default.METADATA),
    SYM_AWARD(RestartBundle.messagePointer("color.token.symbol.trait"), Default.INTERFACE_NAME),
    SYM_EVENT(RestartBundle.messagePointer("color.token.symbol.class"), Default.CLASS_NAME),
    SYM_VARIANT(RestartBundle.messagePointer("color.token.symbol.variant"), Default.STATIC_FIELD),
    SYM_MACRO(RestartBundle.messagePointer("color.token.symbol.macro"), Default.METADATA),
    SYM_LOCAL(RestartBundle.messagePointer("color.token.symbol.local"), Default.LOCAL_VARIABLE),
    SYM_LOCAL_MUT(RestartBundle.messagePointer("color.token.symbol.local.mutable"), Default.REASSIGNED_LOCAL_VARIABLE),
    SYM_GLOBAL(RestartBundle.messagePointer("color.token.symbol.global"), Default.GLOBAL_VARIABLE),
    SYM_GLOBAL_MUT(RestartBundle.messagePointer("color.token.symbol.global.mut"), Default.GLOBAL_VARIABLE),
    SYM_ARG(RestartBundle.messagePointer("color.token.symbol.parameter"), Default.PARAMETER),
    SYM_ARG_MUT(RestartBundle.messagePointer("color.token.symbol.parameter.mutable"), Default.REASSIGNED_PARAMETER),
    SYM_ARG_SELF(RestartBundle.messagePointer("color.token.symbol.self"), Default.KEYWORD),
    SYM_ARG_SELF_MUT(RestartBundle.messagePointer("color.token.symbol.self.mutable"), Default.KEYWORD),
    SYM_PROPERTY(RestartBundle.messagePointer("color.token.symbol.field"), Default.INSTANCE_FIELD),
    SYM_CONSTANT(RestartBundle.messagePointer("color.token.symbol.constant"), Default.CONSTANT),
    SYM_FUNCTION_SELF(RestartBundle.messagePointer("color.token.symbol.function.self"), Default.INSTANCE_METHOD),
    SYM_FUNCTION_FREE(RestartBundle.messagePointer("color.token.symbol.function.free"), Default.STATIC_METHOD),
    //
    TYPE_HINT(RestartBundle.messagePointer("color.token.symbol.type"), Default.CLASS_NAME),

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

    // 废弃
    EXTENSION(OptionsBundle.messagePointer("options.language.defaults.metadata"), Default.METADATA),
    ;

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("voml.lang.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}
