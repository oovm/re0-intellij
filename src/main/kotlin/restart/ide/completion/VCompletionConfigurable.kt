package restart.ide.completion

import restart.ValkyrieBundle
import restart.settings.VCodeInsightSettings
import com.intellij.application.options.CodeCompletionOptionsCustomSection
import com.intellij.openapi.options.ConfigurableBuilder

class VCompletionConfigurable : ConfigurableBuilder(ValkyrieBundle.message("settings.completion.title")),
    CodeCompletionOptionsCustomSection {
    init {
        checkBox(
            ValkyrieBundle.message("settings.completion.suggest_out_of_scope_items"),
            VCodeInsightSettings.getInstance()::suggestOutOfScopeItems
        )
    }
}