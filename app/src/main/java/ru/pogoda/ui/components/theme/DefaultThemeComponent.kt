package ru.pogoda.ui.components.theme

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import ru.pogoda.ui.extensions.componentScope

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultThemeComponent(
    context: ComponentContext,
    private val onBackClicked: () -> Unit,
    private val storeFactory: ThemeStoreFactory,
) : ThemeComponent, ComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }
    private val scope = componentScope()

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    is Theme.Label.OnBackClick -> onBackClicked()
                }
            }
        }
    }

    override val state = store.stateFlow

    override fun onBackClick() {
        store.accept(Theme.Intent.OnBackClick)
    }

    override fun onThemeChange(value: Int) {
        store.accept(Theme.Intent.OnThemeChange(value))
    }

    override fun onLogoChange(value: Int) {
        store.accept(Theme.Intent.OnLogoChange(value))
    }

}