package ru.pogoda.data.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.pogoda.data.repository.LocationRepositoryImpl
import ru.pogoda.data.repository.WeatherRepositoryImpl
import ru.pogoda.domain.repository.LocationRepository
import ru.pogoda.domain.repository.WeatherRepository

private val networkModule = module {
    single {
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
}

private val repositoryModule = module {
    singleOf(::LocationRepositoryImpl) bind LocationRepository::class
    singleOf(::WeatherRepositoryImpl) bind WeatherRepository::class
}

val dataModule = module {
    includes(networkModule, repositoryModule)
}