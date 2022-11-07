package com.example.weatherrepo.presentation.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherrepo.data.WeatherInfo

object WeatherBindingAdapter {

    @JvmStatic
    @BindingAdapter("weather_seoul")
    fun RecyclerView.setSeoulWeathers(seoul: List<WeatherInfo.WeatherDetail>?) {
        seoul?.let { (adapter as? SeoulListAdapter)?.updateSeoulItems(it)}
    }

    @JvmStatic
    @BindingAdapter("weather_london")
    fun RecyclerView.setLondonWeathers(london: List<WeatherInfo.WeatherDetail>?) {
        london?.let { (adapter as? LondonListAdapter)?.updateLondonItems(it)}
    }

    @JvmStatic
    @BindingAdapter("weather_chicago")
    fun RecyclerView.setChicagoWeathers(chicago: List<WeatherInfo.WeatherDetail>?) {
        chicago?.let { (adapter as? ChicagoAdapter)?.updateChicagoItems(it)}
    }


    @JvmStatic
    @BindingAdapter("weather_main")
    fun TextView.setWeatherMain(weatherInfo: WeatherInfo.WeatherDetail) {
        text = weatherInfo.weather.last().main
    }
    @JvmStatic
    @BindingAdapter("weather_temp_max")
    fun TextView.setWeatherMaxMain(weatherInfo: WeatherInfo.WeatherDetail) {
        text = weatherInfo.main.temp_max.let {
            "MAX : ${it}°C"
        }

    }

    @JvmStatic
    @BindingAdapter("weather_temp_min")
    fun TextView.setWeatherMinMain(weatherInfo: WeatherInfo.WeatherDetail) {
        text = weatherInfo.main.temp_min.let {
            "MIN : ${it}°C"
        }    }
}