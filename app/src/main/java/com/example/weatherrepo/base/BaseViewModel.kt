package com.example.weatherrepo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


abstract class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}
