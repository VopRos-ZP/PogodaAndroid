package ru.pogoda.ui.components.city_selection

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import ru.pogoda.ui.extensions.componentScope

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultCitySelectionComponent(
    context: ComponentContext,
    private val onBack: () -> Unit,
    private val onSelected: (String) -> Unit,
    private val storeFactory: CitySelectionStoreFactory,
) : CitySelectionComponent, ComponentContext by context {

    private val store = instanceKeeper.getStore { storeFactory.create() }
    private val scope = componentScope()

    override val state = store.stateFlow

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    is CitySelection.Label.OnBackClick -> onBack()
                    is CitySelection.Label.OnCitySelected -> onSelected(it.value)
                }
            }
        }
    }

    override fun onBackClick() {
        store.accept(CitySelection.Intent.OnBackClick)
    }

    override fun onSearchChange(text: String) {
        store.accept(CitySelection.Intent.OnSearchChange(text))
    }

    override fun onCitySelected(city: String) {
        store.accept(CitySelection.Intent.OnCitySelected(city))
    }

}