package restart.ide.completion

import com.intellij.application.options.CodeCompletionOptionsCustomSection
import com.intellij.openapi.options.ConfigurableBuilder
import restart.RestartBundle
import restart.settings.VCodeInsightSettings

class VCompletionConfigurable : ConfigurableBuilder(RestartBundle.message("settings.completion.title")),
    CodeCompletionOptionsCustomSection {
    init {
        checkBox(
            RestartBundle.message("settings.completion.suggest_out_of_scope_items"),
            VCodeInsightSettings.getInstance()::suggestOutOfScopeItems
        )
    }
}