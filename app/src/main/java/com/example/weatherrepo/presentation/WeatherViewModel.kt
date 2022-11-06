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
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUsecase: WeatherUsecase

) : BaseViewModel() {

    private val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Timber.d("Caugh $throwable" )
    }

    var searchData = MutableLiveData<String>("")

    private val _weatherList = MutableLiveData<List<WeatherInfo?>>()
    val weatherList: LiveData<List<WeatherInfo?>> = _weatherList



    fun getWeatherList(q: String ) {
        viewModelScope.launch {
            try {
                val result = weatherUsecase(q).body()
                Log.d("ddd", result.toString())
                _weatherList.postValue(listOf(result))
            } catch (throwable: Throwable) {

                Timber.e(throwable.message.toString())
            }
        }
    }

}

