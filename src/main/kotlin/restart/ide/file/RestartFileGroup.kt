package restart.ide.file

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider
import com.intellij.ide.projectView.ProjectViewNestingRulesProvider.Consumer
import org.jetbrains.annotations.NotNull

class RestartFileGroup : ProjectViewNestingRulesProvider {
    override fun addFileNestingRules(@NotNull consumer: Consumer) {
        consumer.addNestingRule(".vk", ".json")
        consumer.addNestingRule(".vk", ".md")
    }
}