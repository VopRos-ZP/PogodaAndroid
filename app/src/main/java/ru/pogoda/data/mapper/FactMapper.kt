package ru.pogoda.data.mapper

import ru.pogoda.data.model.FactBlock
import ru.pogoda.domain.model.Fact

fun FactBlock.fromDto(): Fact = Fact(
    obsTime = obsTime,
    dist = dist,
    condition = condition,
    conditionS = conditionS,
    temp = temp,
    feelsLike = feelsLike,
    comfIdx = comfIdx,
    tempWater = tempWater,
    humidity = humidity,
    pressure = pressure,
    windSpeedAvg = windSpeedAvg,
    windDir = windDir,
    light = light,
    uvi = uvi
)