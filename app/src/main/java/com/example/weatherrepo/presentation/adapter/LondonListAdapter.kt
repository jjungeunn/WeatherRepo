package com.example.weatherrepo.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherrepo.data.WeatherInfo
import com.example.weatherrepo.databinding.ItemWeathersBinding

class LondonListAdapter : RecyclerView.Adapter<WeatherViewHolder>() {

    private val items = mutableListOf<WeatherInfo.WeatherDetail>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(
            ItemWeathersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount(): Int = items.size


    fun updateLondonItems(newItems: List<WeatherInfo.WeatherDetail>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}