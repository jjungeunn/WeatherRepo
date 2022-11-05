package com.example.weatherrepo.data


data class WeatherInfo(

    val cod: String,

    val message: Int,

    val list: List<WeatherDetail>,
)

data class WeatherDetail(

    val dt: Int,

    val main: Main,

    val weather: List<Weather>,

    val dt_text: String,

    )

data class Main(

    val tempMax: Double,

    val tempMin: Double
)

data class Weather(

    val description: String,

    val main: String
)