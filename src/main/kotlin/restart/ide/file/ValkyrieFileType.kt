package restart.ide.file

import restart.ValkyrieBundle
import restart.ValkyrieLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object ValkyrieFileType : LanguageFileType(ValkyrieLanguage) {
    override fun getName(): String = ValkyrieLanguage.id

    override fun getDescription(): String = ValkyrieBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "vk;valkyrie;"

    override fun getIcon(): Icon = ValkyrieIconProvider.FILE

}