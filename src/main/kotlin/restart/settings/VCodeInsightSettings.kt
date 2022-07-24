package restart.settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.service
import com.intellij.util.xmlb.XmlSerializerUtil

@State(name = "RestartCodeInsightSettings", storages = [Storage("Restart.xml")])
class VCodeInsightSettings : PersistentStateComponent<VCodeInsightSettings> {

    var showImportPopup: Boolean = false
    var importOutOfScopeItems: Boolean = true
    var suggestOutOfScopeItems: Boolean = true
    var addUnambiguousImportsOnTheFly: Boolean = false

    override fun getState(): VCodeInsightSettings = this

    override fun loadState(state: VCodeInsightSettings) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        fun getInstance(): VCodeInsightSettings = service()
    }
}