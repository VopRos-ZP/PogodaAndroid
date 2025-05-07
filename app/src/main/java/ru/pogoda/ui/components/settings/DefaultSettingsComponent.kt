package ru.pogoda.ui.components.settings

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import ru.pogoda.ui.extensions.componentScope

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultSettingsComponent(
    context: ComponentContext,
    private val onBack: () -> Unit,
    private val onIcon: () -> Unit,
    private val onTheme: () -> Unit,
    private val onPolitics: () -> Unit,
    private val onConditionUse: () -> Unit,
    private val onLocation: () -> Unit,
    private val storeFactory: SettingsStoreFactory,
) : SettingsComponent, ComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }
    private val scope = componentScope()

    override val state = store.stateFlow

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    is Settings.Label.OnBackClick -> onBack()
                }
            }
        }
    }

    override fun onBackClick() {
        store.accept(Settings.Intent.OnBackClick)
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