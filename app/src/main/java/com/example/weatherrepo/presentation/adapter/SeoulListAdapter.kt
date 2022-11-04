package com.example.weatherrepo.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.weatherrepo.R
import com.example.weatherrepo.data.WeatherInfo
import com.example.weatherrepo.presentation.WeatherViewModel

class SeoulListAdapter : ListAdapter<WeatherInfo, WeatherViewHolder>(WeatherDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_weathers,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(getItem(position))
//        if (!viewModel.weatherList.value.isNullOrEmpty()) {
//            holder.bind(viewModel.weatherList.value!![position])
//        }
    }

//    override fun getItemCount(): Int = viewModel.weatherList.value?.size ?: 0
}