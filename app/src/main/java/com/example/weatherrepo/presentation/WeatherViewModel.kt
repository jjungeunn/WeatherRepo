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
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUsecase: WeatherUsecase

) : BaseViewModel() {


    private val _weatherList = MutableLiveData<WeatherInfo?>()
    val weatherList: LiveData<WeatherInfo?> get() = _weatherList

    fun getWeatherList(q: String) {
        viewModelScope.launch {
            try {
                val result = weatherUsecase(q).body()
                _weatherList.postValue(result)


            } catch (throwable: Throwable) {

                Timber.e(throwable.message.toString())
            }
        }
    }

}

