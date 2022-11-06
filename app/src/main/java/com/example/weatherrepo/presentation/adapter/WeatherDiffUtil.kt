package com.example.weatherrepo.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherrepo.data.WeatherInfo

class WeatherDiffUtil : DiffUtil.ItemCallback<WeatherInfo>(){
    override fun areItemsTheSame(oldItem: WeatherInfo, newItem: WeatherInfo) =
        oldItem == newItem


    override fun areContentsTheSame(oldItem: WeatherInfo, newItem: WeatherInfo) =
        oldItem == newItem



}