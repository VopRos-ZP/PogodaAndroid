package ru.pogoda.data.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.flow.flow
import ru.pogoda.data.model.WeatherResponse
import ru.pogoda.domain.repository.LocationRepository
import ru.pogoda.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val httpClient: HttpClient,
    private val locationRepository: LocationRepository
) : WeatherRepository {

    override val weather = flow<WeatherResponse> {
        locationRepository.currentLocation.collect {
            try {
                emit(
                    httpClient.get("http://lb1.hmn.ru/api/dw_api_v1.php") {
                        parameter("cid", "9e5d183cb1779ea8ad19f7dbd000766a")
                        parameter("lat", it.first)
                        parameter("lon", it.second)
                        parameter("type", 1)
                        parameter("period", 1)
                        parameter("mode", "city")
                        parameter("block", "fact")
                    }.body()
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}