package com.example.weatherrepo.domain

import android.util.Log
import com.example.weatherrepo.BuildConfig
import com.example.weatherrepo.data.WeatherInfo
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


class WeatherRepository @Inject constructor(
    private val interfece : MainApiInterface
) {
    suspend fun getWeatherList(q :String) : List<WeatherInfo> {
        return interfece.rqWeather(BuildConfig.API_KEY ,q )
    }




}