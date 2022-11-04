package com.example.weatherrepo.data

/*
{
"coord":{"lon":126.9778,"lat":37.5683},
"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],
"base":"stations",
"main":{"temp":282.49,"feels_like":279.5,"temp_min":281.84,"temp_max":282.91,"pressure":1023,"humidity":20},
"visibility":10000,
"wind":{"speed":6.17,"deg":320},
"clouds":{"all":0},"dt":1667543942,
"sys":{"type":1,"id":8105,"country":"KR","sunrise":1667512775,"sunset":1667550699},
"timezone":32400,"id":1835848,"name":"Seoul","cod":200
}

 */

data class WeatherInfo(
    val weather: List<Weather>,
    val main: Main,
    val dt: Long,
)

data class Weather(
    val main: String,
)

data class Main(
    val temp_min: Double,
    val temp_max: Double,
)
