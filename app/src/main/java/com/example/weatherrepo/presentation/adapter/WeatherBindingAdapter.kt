package com.example.weatherrepo.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherrepo.data.WeatherInfo

object WeatherBindingAdapter {

    @JvmStatic
    @BindingAdapter("weather_seoul")
    fun RecyclerView.setWeathers(seoul: List<WeatherInfo.WeatherDetail>?) {
        seoul?.let { (adapter as? SeoulListAdapter)?.updateSeoulItems(it)}

    }

}