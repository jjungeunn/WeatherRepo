package com.example.weatherrepo.usecase

import androidx.databinding.library.BuildConfig
import com.example.weatherrepo.data.WeatherInfo
import com.example.weatherrepo.domain.WeatherRepository
import retrofit2.Response
import javax.inject.Inject

class WeatherUsecase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(q:String): Response<WeatherInfo> {
        return weatherRepository.getWeatherList(q)
    }
}