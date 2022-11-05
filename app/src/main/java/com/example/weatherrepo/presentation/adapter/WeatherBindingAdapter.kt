package com.example.weatherrepo.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherrepo.data.WeatherInfo
import com.example.weatherrepo.presentation.adapter.WeatherBindingAdapter.setWeathers

object WeatherBindingAdapter {

    @JvmStatic
    @BindingAdapter("weather_seoul")
    fun RecyclerView.setWeathers(seoul: List<WeatherInfo>?) {
        seoul?.let { (adapter as? SeoulListAdapter)?.submitList(it)}
    }


}