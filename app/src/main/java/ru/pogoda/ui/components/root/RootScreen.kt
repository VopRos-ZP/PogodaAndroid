package ru.pogoda.ui.components.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import ru.pogoda.ui.components.city_selection.CitySelectionScreen
import ru.pogoda.ui.components.main.MainScreen
import ru.pogoda.ui.components.onboarding.geo.GeoOnboardingScreen
import ru.pogoda.ui.components.onboarding.push.PushOnboardingScreen
import ru.pogoda.ui.components.splash.SplashScreen

@Composable
fun RootScreen(component: RootComponent) {
    Children(
        stack = component.stack,
        animation = stackAnimation(slide())
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.Splash -> SplashScreen(child.component)
            is RootComponent.Child.GeoOnboarding -> GeoOnboardingScreen(child.component)
            is RootComponent.Child.PushOnboarding -> PushOnboardingScreen(child.component)
            is RootComponent.Child.CitySelection -> CitySelectionScreen(child.component)
            is RootComponent.Child.Main -> MainScreen(child.component)
        }
    }
}