package ru.pogoda.data.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.pogoda.ui.components.city_selection.CitySelectionComponent
import ru.pogoda.ui.components.city_selection.CitySelectionStoreFactory
import ru.pogoda.ui.components.city_selection.DefaultCitySelectionComponent
import ru.pogoda.ui.components.favorites.DefaultFavoritesComponent
import ru.pogoda.ui.components.favorites.FavoritesComponent
import ru.pogoda.ui.components.favorites.FavoritesStoreFactory
import ru.pogoda.ui.components.main.DefaultMainComponent
import ru.pogoda.ui.components.main.MainComponent
import ru.pogoda.ui.components.main.MainStoreFactory
import ru.pogoda.ui.components.onboarding.geo.GeoOnboardingComponent
import ru.pogoda.ui.components.onboarding.geo.DefaultGeoOnboardingComponent
import ru.pogoda.ui.components.onboarding.push.PushOnboardingComponent
import ru.pogoda.ui.components.onboarding.push.DefaultPushOnboardingComponent
import ru.pogoda.ui.components.root.DefaultRootComponent
import ru.pogoda.ui.components.root.RootComponent
import ru.pogoda.ui.components.settings.DefaultSettingsComponent
import ru.pogoda.ui.components.settings.SettingsComponent
import ru.pogoda.ui.components.settings.SettingsStoreFactory
import ru.pogoda.ui.components.splash.DefaultSplashComponent
import ru.pogoda.ui.components.splash.SplashComponent
import ru.pogoda.ui.components.splash.SplashStoreFactory

private val storesModule = module {
    single<StoreFactory> { LoggingStoreFactory(DefaultStoreFactory()) }

    singleOf(::SplashStoreFactory)
    singleOf(::CitySelectionStoreFactory)
    singleOf(::MainStoreFactory)
    singleOf(::SettingsStoreFactory)
    singleOf(::FavoritesStoreFactory)
}

private val componentsModule = module {
    factoryOf(::DefaultRootComponent) bind RootComponent::class
    factoryOf(::DefaultSplashComponent) bind SplashComponent::class
    factoryOf(::DefaultGeoOnboardingComponent) bind GeoOnboardingComponent::class
    factoryOf(::DefaultPushOnboardingComponent) bind PushOnboardingComponent::class
    factoryOf(::DefaultCitySelectionComponent) bind CitySelectionComponent::class
    factoryOf(::DefaultMainComponent) bind MainComponent::class
    factoryOf(::DefaultSettingsComponent) bind SettingsComponent::class
    factoryOf(::DefaultFavoritesComponent) bind FavoritesComponent::class
}

val presentationModule = module {
    includes(storesModule, componentsModule)
}