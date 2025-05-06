package ru.pogoda.domain.repository

import ru.pogoda.domain.model.Fact

interface WeatherRepository {

    suspend fun fetchFact(
        lat: Double,
        lon: Double,
        period: String,
        type: String,
        mode: String,
        block: String,
    ): Fact

}