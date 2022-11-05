package com.example.weatherrepo.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.weatherrepo.BR
import com.example.weatherrepo.data.WeatherInfo
import com.example.weatherrepo.databinding.ItemWeathersBinding

class WeatherViewHolder(
    private val binding: ItemWeathersBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WeatherInfo) {
        binding.run {
            item.list.forEach {
                it.weather.forEach{
                    tvDate.setText(it.main)
                }
            }
            setVariable(BR.weather, item)
            executePendingBindings()
        }

    }
}