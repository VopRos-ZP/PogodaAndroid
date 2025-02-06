package ru.pogoda.ui.components.theme

import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ru.pogoda.ui.decompose.context.AppComponentContext

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultThemeComponent(
    context: AppComponentContext,
    private val onBack: () -> Unit,
    private val storeFactory: ThemeStoreFactory,
) : ThemeComponent, AppComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }

    override val state = store.stateFlow

    override fun onBackClick() {
        onBack()
    }

    override fun onThemeChange(value: Int) {
        store.accept(Theme.Intent.OnThemeChange(value))
    }

    override fun onLogoChange(value: Int) {
        store.accept(Theme.Intent.OnLogoChange(value))
    }

}