package ru.pogoda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import org.koin.androidx.compose.KoinAndroidContext
import ru.pogoda.ui.components.root.RootComponent
import ru.pogoda.ui.components.root.RootScreen
import ru.pogoda.ui.decompose.context.DefaultAppComponentContext
import ru.pogoda.ui.theme.PogodaTheme

class MainActivity : ComponentActivity(), KoinComponent {

    private val rootComponent by inject<RootComponent> {
        parametersOf(
            DefaultAppComponentContext(
                componentContext = defaultComponentContext(),
                scope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoinAndroidContext {
                PogodaTheme(
                    dynamicColor = false
                ) {
                    RootScreen(component = rootComponent)
                }
            }
        }
    }
}
