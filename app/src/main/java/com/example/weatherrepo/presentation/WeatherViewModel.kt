package com.example.weatherrepo.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherrepo.base.BaseViewModel
import com.example.weatherrepo.data.WeatherInfo
import com.example.weatherrepo.usecase.WeatherUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUsecase: WeatherUsecase

) : BaseViewModel() {


    private val _weatherList = MutableLiveData<List<WeatherInfo>>()
    val weatherList: LiveData<List<WeatherInfo>> get() = _weatherList


    init {
        getWeatherList("seoul")
    }

    fun getWeatherList(q :String) {
        viewModelScope.launch {
            try {
                val result = weatherUsecase.invoke(q)
                _weatherList.value = result
                Log.d("@@@value", result.toString())

            }catch (throwable : Throwable) {
                Timber.d( throwable.message.toString())



            }
        }
    }

}
//        try {
//
//            val result = weatherUsecase(37.5437, 127.0347)
//            _weatherList.value = result
//        } catch (e: Throwable) {
//            Log.d("getWeatherListException", "$e")
//        }
