package ru.pogoda.ui.components.settings

import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ru.pogoda.ui.decompose.context.AppComponentContext

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultSettingsComponent(
    context: AppComponentContext,
    private val onBack: () -> Unit,
    private val onIcon: () -> Unit,
    private val onTheme: () -> Unit,
    private val onPolitics: () -> Unit,
    private val onConditionUse: () -> Unit,
    private val onLocation: () -> Unit,
    private val storeFactory: SettingsStoreFactory,
) : SettingsComponent, AppComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }

    override val state = store.stateFlow

    override fun onBackClick() {
        onBack()
    }

    override fun onTempChange(value: Int) {
        store.accept(Settings.Intent.OnTempChange(value))
    }

    override fun onWindChange(value: Int) {
        store.accept(Settings.Intent.OnWindChange(value))
    }

    override fun onPressureChange(value: Int) {
        store.accept(Settings.Intent.OnPressureChange(value))
    }

    override fun onTimeChange(value: Int) {
        store.accept(Settings.Intent.OnTimeChange(value))
    }

    override fun onIconChangeClick() {
        onIcon()
    }

    override fun onThemeChangeClick() {
        onTheme()
    }

    override fun onPoliticsClick() {
        onPolitics()
    }

    override fun onConditionUseClick() {
        onConditionUse()
    }

    override fun onLocationClick() {
        onLocation()
    }
}