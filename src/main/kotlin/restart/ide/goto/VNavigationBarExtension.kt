package restart.ide.goto

import restart.RestartLanguage
import com.intellij.ide.navigationToolbar.AbstractNavBarModelExtension
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension
import com.intellij.lang.Language
import com.intellij.openapi.roots.*
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.psi.*
import com.intellij.util.Processor

/// 重写导航栏
class VNavigationBarExtension : StructureAwareNavBarModelExtension() {
    override val language: Language = RestartLanguage

    override fun getPresentableText(`object`: Any?): String? {
        return null
    }
}
