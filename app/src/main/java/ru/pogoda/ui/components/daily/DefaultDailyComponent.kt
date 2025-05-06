package ru.pogoda.ui.components.daily

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.pogoda.ui.extensions.componentScope

class DefaultDailyComponent(
    context: ComponentContext,
    private val onBack: () -> Unit,
) : DailyComponent, ComponentContext by context {

    private val scope = componentScope()

    override val state: StateFlow<Daily.State>
        get() = TODO("Not yet implemented")

    init {
        scope.launch {

        }
    }

    override fun onBackClick() {
        onBack()
    }

}