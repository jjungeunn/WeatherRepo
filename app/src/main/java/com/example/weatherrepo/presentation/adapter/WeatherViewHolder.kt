package com.example.weatherrepo.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.weatherrepo.BR
import com.example.weatherrepo.R
import com.example.weatherrepo.data.WeatherInfo
import com.example.weatherrepo.databinding.ItemWeathersBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class WeatherViewHolder(
    private val binding: ItemWeathersBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WeatherInfo.WeatherDetail) {
        binding.run {
            setVariable(BR.weather, item)
            executePendingBindings()



            tvMax.setText("MAX :${item.main.temp_max}°C")
            tvMin.setText("MIN : ${item.main.temp_min}°C")
            item.weather.forEach {
                tvMain.setText(it.description)
            }
            item.weather.forEach {
                when(it.id) {
                    in 200..299 ->  {ivIcon.setImageResource(R.drawable.im_storm)}
                    in 300..599 -> {ivIcon.setImageResource(R.drawable.im_rain)}
                    in 600..700 ->  {ivIcon.setImageResource(R.drawable.im_snow)}
                    in 701..771 ->{ivIcon.setImageResource(R.drawable.im_fog)}
                    in 772..799 ->{ivIcon.setImageResource(R.drawable.im_cloudy)}
                    in 801..804 ->{ivIcon.setImageResource(R.drawable.im_cloudy)}
                    in 900..902 -> {ivIcon.setImageResource(R.drawable.im_storm)}
                    903 -> {ivIcon.setImageResource(R.drawable.im_snow)}
                    800 -> {ivIcon.setImageResource(R.drawable.im_sunny)}
                    else -> {ivIcon.setImageResource(R.drawable.im_sunny)}
               }
            }


        }

    }
}