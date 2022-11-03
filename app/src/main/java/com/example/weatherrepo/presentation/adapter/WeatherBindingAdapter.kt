package com.example.weatherrepo.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherrepo.data.WeatherInfo

object WeatherBindingAdapter {

    @JvmStatic
    @BindingAdapter("weather_seoul")
    fun RecyclerView.setCategories(seoul: List<WeatherInfo>?) {
        seoul?.let { (adapter as? SeoulListAdapter)?.submitList(it) }
    }
}