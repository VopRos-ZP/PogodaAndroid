package ru.pogoda.data.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ru.pogoda.data.mapper.fromDto
import ru.pogoda.data.model.WeatherResponse
import ru.pogoda.domain.model.Fact
import ru.pogoda.domain.repository.WeatherRepository
import ru.pogoda.domain.utils.BASE_URL
import ru.pogoda.domain.utils.CID
import ru.pogoda.domain.utils.PARAM_BLOCK
import ru.pogoda.domain.utils.PARAM_CID
import ru.pogoda.domain.utils.PARAM_LAT
import ru.pogoda.domain.utils.PARAM_LON
import ru.pogoda.domain.utils.PARAM_MODE
import ru.pogoda.domain.utils.PARAM_PERIOD
import ru.pogoda.domain.utils.PARAM_TYPE

class WeatherRepositoryImpl(
    private val httpClient: HttpClient,
) : WeatherRepository {

    override suspend fun fetchFact(
        lat: Double,
        lon: Double,
        period: String,
        type: String,
        mode: String,
        block: String
    ): Fact {
        return try {
            httpClient.get(BASE_URL) {
                parameter(PARAM_CID, CID)
                parameter(PARAM_LAT, lat)
                parameter(PARAM_LON, lon)
                parameter(PARAM_TYPE, type)
                parameter(PARAM_PERIOD, period)
                parameter(PARAM_MODE, mode)
                parameter(PARAM_BLOCK, block)
            }.body<WeatherResponse>().fact.fromDto()
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

}