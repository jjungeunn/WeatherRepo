package com.example.weatherrepo.data

data class WeatherInfo(
    val weather: Weather,
    val main: Main
)

data class Weather(
    val main: String,

    )

data class Main(
    val main: String,
    val temp_min: Double,
    val temp_max: Double

)
