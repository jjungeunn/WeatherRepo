package com.example.weatherrepo.presentation

import android.os.Bundle
import androidx.activity.viewModels
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
    private val seoul_adapter: SeoulListAdapter by lazy { SeoulListAdapter() }
    private val london_adapter: LondonListAdapter by lazy { LondonListAdapter() }
    private val chicago_adapter: ChicagoAdapter by lazy { ChicagoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            rvSeoul.adapter = seoul_adapter
            rvLondon.adapter = london_adapter
            rvChicago.adapter = chicago_adapter
        }
        viewModel.getWeatherList()

        observe()
    }

    private fun observe() {
        viewModel.weatheSeoulrList.observe(this, {
            if (it != null) {
                seoul_adapter.updateSeoulItems(it)
            }
        })
        viewModel.weatheLondonList.observe(this, {
            if (it != null) {
                london_adapter.updateLondonItems(it)
            }
        })
        viewModel.weatheChicagoList.observe(this, {
            if (it != null) {
                chicago_adapter.updateChicagoItems(it)
            }
        })

    }
}