package com.example.weatherrepo.usecase

import com.example.weatherrepo.data.Weather
import com.example.weatherrepo.domain.WeatherRepository
import javax.inject.Inject

class WeatherUsecase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
//    suspend operator fun invoke(): List<Weather> {
//        return weatherRepository.getWeatherInfo()
//    }
}