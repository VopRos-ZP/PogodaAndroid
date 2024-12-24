package ru.pogoda.ui.components.city_selection

import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ru.pogoda.ui.decompose.context.AppComponentContext

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultCitySelectionComponent(
    context: AppComponentContext,
    private val onBack: () -> Unit,
    private val onSelected: (String) -> Unit,
    private val storeFactory: CitySelectionStoreFactory,
) : CitySelectionComponent, AppComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }

    override val state = store.stateFlow

    override fun onBackClick() {
        onBack()
    }

    override fun onSearchChange(text: String) {
        store.accept(CitySelection.Intent.OnSearchChange(text))
    }

    override fun onCitySelected(city: String) {
        onSelected(city)
    }

}