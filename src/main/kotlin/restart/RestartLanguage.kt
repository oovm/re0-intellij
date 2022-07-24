package restart

import com.intellij.lang.Language

private const val LanguageID = "Restart"

object RestartLanguage: Language(LanguageID) {
    override fun getDisplayName(): String {
        return super.getDisplayName()
    }
    override fun getMimeTypes(): Array<String> {
        return arrayOf("text/x-Restart")
    }
}