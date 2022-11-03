package com.example.weatherrepo.domain

import com.example.weatherrepo.BuildConfig
import com.example.weatherrepo.data.WeatherInfo
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val interfece : MainApiInterface
) {
    suspend fun getWeatherList(q :String) : Response<WeatherInfo> =
        interfece.rqWeather(BuildConfig.API_KEY ,q )


}