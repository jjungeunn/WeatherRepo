package com.example.weatherrepo.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.weatherrepo.BR
import com.example.weatherrepo.R
import com.example.weatherrepo.base.BaseActivity
import com.example.weatherrepo.databinding.ActivityWeatherBinding
import com.example.weatherrepo.presentation.adapter.SeoulListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity() :
    BaseActivity<ActivityWeatherBinding>(R.layout.activity_weather){


    override val viewModel: WeatherViewModel by viewModels()
    private val adapters : SeoulListAdapter by lazy { SeoulListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.run {
            setVariable(BR.vm, this@WeatherActivity.viewModel)

            rvSeoul.adapter = adapters
        }

        viewModel.getWeatherList("seoul")
    }
}