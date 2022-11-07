package com.example.weatherrepo.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.weatherrepo.BR
import com.example.weatherrepo.R
import com.example.weatherrepo.base.BaseActivity
import com.example.weatherrepo.databinding.ActivityWeatherBinding
import com.example.weatherrepo.presentation.adapter.ChicagoAdapter
import com.example.weatherrepo.presentation.adapter.LondonListAdapter
import com.example.weatherrepo.presentation.adapter.SeoulListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity() :
    BaseActivity<ActivityWeatherBinding>(R.layout.activity_weather) {


    override val viewModel: WeatherViewModel by viewModels()

    private val seoul_adapter: SeoulListAdapter = SeoulListAdapter()
    private val london_adapter: LondonListAdapter = LondonListAdapter()
    private val chicago_adapter: ChicagoAdapter = ChicagoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            setVariable(BR.vm, this@WeatherActivity.viewModel)

            rvSeoul.adapter = seoul_adapter
            rvLondon.adapter = london_adapter
            rvChicago.adapter = chicago_adapter
        }

        viewModel.getWeatherList()
    }
}