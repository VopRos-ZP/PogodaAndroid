package ru.pogoda.ui.decompose.context

import com.arkivanov.decompose.GenericComponentContext
import kotlinx.coroutines.CoroutineScope

interface AppComponentContext : GenericComponentContext<AppComponentContext> {
    val scope: CoroutineScope
}