package com.example.weatherrepo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.weatherrepo.R
import com.example.weatherrepo.base.BaseActivity
import com.example.weatherrepo.base.BaseViewModel
import com.example.weatherrepo.databinding.ActivityWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity() :
    BaseActivity<ActivityWeatherBinding>(R.layout.activity_weather){

    override val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
    }
}