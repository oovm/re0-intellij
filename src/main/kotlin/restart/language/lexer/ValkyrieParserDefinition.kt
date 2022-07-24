package restart.language.lexer


import restart.ValkyrieLanguage
import restart.ide.file.ValkyrieFileNode
import restart.language.parser.RestartParser
import restart.language.psi.RestartTypes

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet


object ValkyrieParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = ValkyrieLexerAdapter()

    override fun createParser(project: Project): PsiParser = _root_ide_package_.restart.language.parser.RestartParser()

    override fun getFileNodeType(): IFileElementType = IFileElementType(ValkyrieLanguage)

    override fun getWhitespaceTokens(): TokenSet {
        return super.getWhitespaceTokens()
    }

    override fun getCommentTokens(): TokenSet = TokenSet.create(RestartTypes.COMMENT)

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.create(RestartTypes.STRING_START, RestartTypes.STRING_TEXT, RestartTypes.STRING_END)
    }

    override fun createElement(node: ASTNode): PsiElement = RestartTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = ValkyrieFileNode(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
        return SpaceRequirements.MAY
    }
}