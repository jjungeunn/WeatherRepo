package com.example.weatherrepo.presentation

import android.os.Bundle
import com.example.weatherrepo.R
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.weatherrepo.base.BaseActivity
import com.example.weatherrepo.databinding.ActivityWeatherBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WeatherActivity() :
    BaseActivity<ActivityWeatherBinding>(R.layout.activity_weather){


    override val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val viewModel: WeatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)



//        binding.run {
//            setVariable(BR.viewModel, this@WeatherActivity.viewModel)
//        }
    }
}