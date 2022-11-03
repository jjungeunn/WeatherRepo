package com.example.weatherrepo.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherrepo.base.BaseViewModel
import com.example.weatherrepo.data.WeatherInfo
import com.example.weatherrepo.usecase.WeatherUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUsecase: WeatherUsecase

) : BaseViewModel() {



    private val _weatherList = MutableLiveData<List<WeatherInfo>>()
    val weatherList: LiveData<List<WeatherInfo>> get() = _weatherList

    suspend fun getWeatherList()  = viewModelScope.launch {
        val response = withContext(Dispatchers.IO) {

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
