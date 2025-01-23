package ru.pogoda.ui.components.daily

import kotlinx.coroutines.flow.StateFlow
import ru.pogoda.ui.decompose.context.AppComponentContext

class DefaultDailyComponent(
    context: AppComponentContext,
    private val onBack: () -> Unit,
) : DailyComponent, AppComponentContext by context {

    override val state: StateFlow<Daily.State>
        get() = TODO("Not yet implemented")

    override fun onBackClick() {
        onBack()
    }

}