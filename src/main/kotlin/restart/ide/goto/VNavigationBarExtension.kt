package restart.ide.goto

import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension
import com.intellij.lang.Language
import restart.RestartLanguage

/// 重写导航栏
class VNavigationBarExtension : StructureAwareNavBarModelExtension() {
    override val language: Language = RestartLanguage

    override fun getPresentableText(`object`: Any?): String? {
        return null
    }
}
