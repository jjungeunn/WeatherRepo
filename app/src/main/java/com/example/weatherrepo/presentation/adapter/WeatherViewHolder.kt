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

            tvDate.text = item.dt_txt

            item.weather.last().let { //weather값이 여러개인 케이스가 없었으므로 가장 마지막 값 사용.
                val resource = when(it.id) {
                    in 200..299 -> R.drawable.im_storm
                    in 300..599 -> R.drawable.im_rain
                    in 600..700 -> R.drawable.im_snow
                    in 701..771 -> R.drawable.im_fog
                    in 772..799 -> R.drawable.im_cloudy
                    in 801..804 -> R.drawable.im_cloudy
                    in 900..902 -> R.drawable.im_storm
                    903 -> R.drawable.im_snow
                    800 -> R.drawable.im_sunny
                    else -> R.drawable.im_sunny
               }

                ivIcon.setImageResource(resource)
            }
        }
    }
}