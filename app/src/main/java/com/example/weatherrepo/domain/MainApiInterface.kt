package com.example.weatherrepo.domain

import com.example.weatherrepo.data.WeatherInfo
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface MainApiInterface {

    @JvmSuppressWildcards
    @Headers("Content-Type: application/json")
    @POST("data/2.5/weather?")
    suspend fun rqWeather(
        @Header("Authorization") Authorization: String = "",
        @Query("q") q: String,

    ): Response<WeatherInfo>
}