package ru.pogoda.domain.repository

import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    val currentLocation: Flow<Pair<Double, Double>>
}