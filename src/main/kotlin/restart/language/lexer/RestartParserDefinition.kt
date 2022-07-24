package restart.language.lexer


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
import restart.RestartLanguage
import restart.ide.file.RestartFileNode
import restart.language.parser.RestartParser
import restart.language.psi.RestartTypes


object RestartParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = RestartLexerAdapter()

    override fun createParser(project: Project): PsiParser = RestartParser()

    override fun getFileNodeType(): IFileElementType = IFileElementType(RestartLanguage)

    override fun getCommentTokens(): TokenSet = TokenSet.create(RestartTypes.COMMENT_SL, RestartTypes.COMMENT_TEXT)

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.create(RestartTypes.STRING_START, RestartTypes.STRING_TEXT, RestartTypes.STRING_END)
    }

    override fun createElement(node: ASTNode): PsiElement = RestartTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = RestartFileNode(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
        return SpaceRequirements.MAY
    }
}
