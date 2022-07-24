package restart.ide.file

import com.intellij.openapi.fileTypes.LanguageFileType
import restart.RestartBundle
import restart.RestartLanguage
import javax.swing.Icon

object RestartFileType : LanguageFileType(RestartLanguage) {
    override fun getName(): String = RestartLanguage.id

    override fun getDescription(): String = RestartBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "re0;restart;"

    override fun getIcon(): Icon = RestartIconProvider.FILE

}