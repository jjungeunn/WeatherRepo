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
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUsecase: WeatherUsecase

) : BaseViewModel() {

    private val _weatheSeoulrList = MutableLiveData<List<WeatherInfo.WeatherDetail>?>()
    val weatheSeoulrList: MutableLiveData<List<WeatherInfo.WeatherDetail>?> = _weatheSeoulrList

    private val _weatheLondonList = MutableLiveData<List<WeatherInfo.WeatherDetail>?>()
    val weatheLondonList: MutableLiveData<List<WeatherInfo.WeatherDetail>?> = _weatheLondonList

    private val _weatheChicagoList = MutableLiveData<List<WeatherInfo.WeatherDetail>?>()
    val weatheChicagoList: MutableLiveData<List<WeatherInfo.WeatherDetail>?> = _weatheChicagoList
    
    fun getWeatherList() {
        viewModelScope.launch {
            try {
                val seoul_result = weatherUsecase("seoul").body()?.list
                _weatheSeoulrList.postValue(seoul_result)

                val london_result = weatherUsecase("london").body()?.list
                _weatheLondonList.postValue(london_result)

                val chicago_result = weatherUsecase("chicago").body()?.list
                _weatheChicagoList.postValue(chicago_result)

            } catch (throwable: Throwable) {
                Timber.e(throwable.message.toString())
            }
        }
    }




}

