package ru.pogoda.ui.components.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.pogoda.ui.components.city_selection.CitySelectionComponent
import ru.pogoda.ui.components.daily.DailyComponent
import ru.pogoda.ui.components.favorites.FavoritesComponent
import ru.pogoda.ui.components.main.MainComponent
import ru.pogoda.ui.components.onboarding.geo.GeoOnboardingComponent
import ru.pogoda.ui.components.onboarding.push.PushOnboardingComponent
import ru.pogoda.ui.components.settings.SettingsComponent
import ru.pogoda.ui.components.splash.SplashComponent
import ru.pogoda.ui.components.theme.ThemeComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {
        data class Splash(val component: SplashComponent) : Child
        data class GeoOnboarding(val component: GeoOnboardingComponent) : Child
        data class PushOnboarding(val component: PushOnboardingComponent) : Child
        data class CitySelection(val component: CitySelectionComponent) : Child
        data class Main(val component: MainComponent) : Child
        data class Settings(val component: SettingsComponent) : Child
        data class Favorites(val component: FavoritesComponent) : Child
        data class Daily(val component: DailyComponent) : Child
        data class Theme(val component: ThemeComponent) : Child
    }

}