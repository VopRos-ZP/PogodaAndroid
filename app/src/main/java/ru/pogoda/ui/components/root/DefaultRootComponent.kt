package ru.pogoda.ui.components.root

import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import ru.pogoda.ui.components.city_selection.CitySelection
import ru.pogoda.ui.components.main.Main
import ru.pogoda.ui.components.onboarding.geo.GeoOnboarding
import ru.pogoda.ui.components.onboarding.push.PushOnboarding
import ru.pogoda.ui.components.root.RootComponent.Child
import ru.pogoda.ui.components.splash.Splash
import ru.pogoda.ui.decompose.context.AppComponentContext

@OptIn(DelicateDecomposeApi::class)
class DefaultRootComponent(
    componentContext: AppComponentContext,
) : RootComponent, KoinComponent, AppComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Splash,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(config: Config, context: AppComponentContext) =
        when (config) {
            is Config.Splash -> Child.Splash(
                get(
                    parameters = Splash.params(
                        context = context,
                        onOnboarding = { navigation.replaceCurrent(Config.GeoOnboarding) },
                        onMain = { navigation.replaceCurrent(Config.Main) }
                    )
                )
            )
            is Config.GeoOnboarding -> Child.GeoOnboarding(
                get(
                    parameters = GeoOnboarding.params(
                        context = context,
                        onPermissionGrated = { navigation.replaceCurrent(Config.PushOnboarding) },
                        onCustomizeClick = { navigation.replaceCurrent(Config.CitySelection) }
                    )
                )
            )
            is Config.PushOnboarding -> Child.PushOnboarding(
                get(
                    parameters = PushOnboarding.params(
                        context = context,
                        onPermissionGrated = { navigation.push(Config.Main) }
                    )
                )
            )
            is Config.CitySelection -> Child.CitySelection(
                get(
                    parameters = CitySelection.params(
                        context = context,
                        onBackClick = { navigation.replaceCurrent(Config.PushOnboarding) },
                        onCitySelected = { navigation.replaceCurrent(Config.PushOnboarding) }
                    )
                )
            )
            is Config.Main -> Child.Main(
                get(
                    parameters = Main.params(
                        context = context,
                    )
                )
            )
        }

    @Serializable
    sealed interface Config {

        @Serializable
        data object Splash : Config

        @Serializable
        data object GeoOnboarding : Config

        @Serializable
        data object PushOnboarding : Config

        @Serializable
        data object CitySelection : Config

        @Serializable
        data object Main : Config

    }

}