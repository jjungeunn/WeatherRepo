package com.example.weatherrepo.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherrepo.base.BaseViewModel
import com.example.weatherrepo.data.WeatherInfo
import com.example.weatherrepo.usecase.WeatherUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUsecase: WeatherUsecase

) : BaseViewModel() {

    private val _weatherSeoulList = MutableLiveData<List<WeatherInfo.WeatherDetail>?>()
    val weatherSeoulList: LiveData<List<WeatherInfo.WeatherDetail>?> = _weatherSeoulList

    private val _weatherLondonList = MutableLiveData<List<WeatherInfo.WeatherDetail>?>()
    val weatherLondonList: LiveData<List<WeatherInfo.WeatherDetail>?> = _weatherLondonList

    private val _weatherChicagoList = MutableLiveData<List<WeatherInfo.WeatherDetail>?>()
    val weatherChicagoList: LiveData<List<WeatherInfo.WeatherDetail>?> = _weatherChicagoList
    
    fun getWeatherList() {
        viewModelScope.launch {
            try {
                val seoul_result = weatherUsecase("seoul").body()?.list
                val london_result = weatherUsecase("london").body()?.list
                val chicago_result = weatherUsecase("chicago").body()?.list

                _weatherSeoulList.value = filterByDate(seoul_result)
                _weatherLondonList.value = filterByDate(london_result)
                _weatherChicagoList.value = filterByDate(chicago_result)
            } catch (throwable: Throwable) {
                Timber.e(throwable.message.toString())
            }
        }
    }

    private fun filterByDate(weatherDetail: List<WeatherInfo.WeatherDetail>?): List<WeatherInfo.WeatherDetail>? {
        val map: MutableMap<String, WeatherInfo.WeatherDetail> = mutableMapOf()

        weatherDetail?.forEach {
            val date = it.dt_txt.split(" ").first()
            if (map[date] == null) { // 해당 날짜의 가장 첫번째 시간만
                map[date] = it
            }
        }

        return map.values.toList()
    }
}

