package com.example.weatherrepo.domain

import com.example.weatherrepo.data.WeatherInfo
import retrofit2.Response
import retrofit2.http.*

interface MainApiInterface {

    @JvmSuppressWildcards
    @Headers("Content-Type: application/json")
    @GET("data/2.5/forecast?")
    suspend fun rqWeather(
        @Query("appId") appId: String ,
        @Query("q") q: String,
        @Query("cnt") cnt: Int,
    ): Response<WeatherInfo>
}